package com.example.Week2Module.demoSpringBootIntro.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Setter
@Getter
public class EmployeeEntity {

    @Id  // It is basically the to define the primary Key Neeche wala hmko autogenerate krke dega
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private Double salary;
    private String name;

    private String email;

     private String role;

    private Integer age;

    private LocalDate dateOfJoining;

    private Boolean isActive;
}
