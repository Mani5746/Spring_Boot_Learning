package com.example.Week2Module.demoSpringBootIntro.dto;

import com.example.Week2Module.demoSpringBootIntro.Annotations.EmployeeRoleValidation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {


    private Long id;

   @NotNull(message="Required field in Employee: name")
   @Size(min = 3,max = 8,message = "Number of characters in name should be in range: {3:10}")
    private String name;

    @NotBlank(message = "Email of the employee cannot be blank")
   @Email(message = "Email should be a valid email")
    private String email;

 @NotBlank(message = "Role of the employee cannot be blank")
// @Pattern(regexp = "^ADMIN|USER")
@EmployeeRoleValidation
 private String role;

 @NotNull(message = "Salary should not be null")
 @Digits(integer = 6,fraction = 2,message = "Salary should be in the form XXXX.XX")
    private Double salary;


    private Integer age;


    private LocalDate dateOfJoining;

    private Boolean isActive;

}
