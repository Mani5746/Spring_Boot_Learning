package com.example.Week2Module.demoSpringBootIntro.controllers;

import com.example.Week2Module.demoSpringBootIntro.dto.EmployeeDTO;
import com.example.Week2Module.demoSpringBootIntro.entities.EmployeeEntity;
import com.example.Week2Module.demoSpringBootIntro.repository.EmployeeRepository;
import com.example.Week2Module.demoSpringBootIntro.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController

@RequestMapping(path = "/employees") // This will create the Default Path  for both Get and Post but It will prefer Get
// and for POSt,put and also We can use GET via Postman too  We have to use POSTMan
public class EmployeeController {

//  @GetMapping(path = "/getSecretMessage")
//
//    public String getMySuperSecretMessage(){
//      return "Secret message: hjnkmngbd23454";
//  }

private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //@GetMapping("/employees/{employeeID}")
  @GetMapping(path = "/{employeeID}")
  public EmployeeDTO getEmployeeID(@PathVariable (name = "employeeID") Long id){
      return employeeService.getEmployeeById(id);
}

  @GetMapping
  public List<EmployeeDTO> getAllEmployees(@RequestParam(required=false,name="inputAge") Integer age, @RequestParam(required=false) String sortBy){

    return employeeService.getAllEmployees();
  }

  @PostMapping()  // We have to sent it via Client like Postman
  public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){

    return employeeService.createNewEmployee(inputEmployee);
  }

  @PutMapping()
  public String updateEmployee(){
    return "Hello from Put";
  }

}
