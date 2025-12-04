package com.example.Week2Module.demoSpringBootIntro.controllers;

import com.example.Week2Module.demoSpringBootIntro.dto.EmployeeDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
@RestController

@RequestMapping(path = "/employees") // This will create the Default Path  for both Get and Post but It will prefer Get
// and for POSt,put and also We can use GET via Postman too  We have to use POSTMan
public class EmployeeController {

//  @GetMapping(path = "/getSecretMessage")
//
//    public String getMySuperSecretMessage(){
//      return "Secret message: hjnkmngbd23454";
//  }

  //@GetMapping("/employees/{employeeID}")
  @GetMapping(path = "/{employeeID}")
  public EmployeeDTO getEmployeeID(@PathVariable Long employeeID){
  return new EmployeeDTO(employeeID,"Manish","abc@gmail.com",25, LocalDate.of(2024,1,12),true);
}

  @GetMapping(path = "/employees")
  public String getAllEmployees(@RequestParam(required=false) Integer age,@RequestParam(required=false) String sortBy){

    return "Hi age "+ age + " " +sortBy;
  }

  @PostMapping()  // We have to sent it via Client like Postman
  public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){

    inputEmployee.setId(100L);
    return inputEmployee;
  }

  @PutMapping()
  public String updateEmployee(){
    return "Hello from Put";
  }

}
