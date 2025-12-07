package com.example.Week2Module.demoSpringBootIntro.controllers;

import com.example.Week2Module.demoSpringBootIntro.dto.EmployeeDTO;
import com.example.Week2Module.demoSpringBootIntro.entities.EmployeeEntity;
import com.example.Week2Module.demoSpringBootIntro.repository.EmployeeRepository;
import com.example.Week2Module.demoSpringBootIntro.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.example.Week2Module.demoSpringBootIntro.services.EmployeeService.*;

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
  public ResponseEntity<EmployeeDTO> getEmployeeID(@PathVariable (name = "employeeID") Long id){
      Optional< EmployeeDTO> employeeDTO= employeeService.getEmployeeById(id);

       return employeeDTO.
               map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1)).
               orElse(ResponseEntity.notFound().build());
}

  @GetMapping
  public ResponseEntity<List<EmployeeDTO>> getAllEmployees(@RequestParam(required=false,name="inputAge") Integer age, @RequestParam(required=false) String sortBy){

    return ResponseEntity.ok(employeeService.getAllEmployees());
  }

  @PostMapping()  // We have to sent it via Client like Postman
  public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody EmployeeDTO inputEmployee){

    EmployeeDTO savedEmployee= employeeService.createNewEmployee(inputEmployee);
    return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
  }

  @PutMapping(path="/{employeeID}")
  public ResponseEntity<EmployeeDTO> updateEmployeeById(@RequestBody EmployeeDTO employeeDTO,@PathVariable Long employeeID)
  {
     return ResponseEntity.ok(employeeService.updateEmployeeById(employeeDTO, employeeID));
  }

  @DeleteMapping(path="/{employeeID}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable Long employeeID){
       boolean gotDeleted= employeeService.deleteById(employeeID);
       if(gotDeleted) return ResponseEntity.ok(true);

       return ResponseEntity.notFound().build();
  }

    @PatchMapping(path = "/{employeeID}")
    public ResponseEntity<EmployeeDTO> updatePartialEmployeeById(
            @PathVariable("employeeID") Long employeeId,
            @RequestBody Map<String, Object> updates) {

        EmployeeDTO employeeDTO= employeeService.updatePartialById(employeeId, updates);
        if(employeeDTO==null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(employeeDTO);
    }



}
