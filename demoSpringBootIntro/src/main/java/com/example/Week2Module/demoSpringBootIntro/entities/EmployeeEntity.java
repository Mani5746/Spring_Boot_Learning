package com.example.Week2Module.demoSpringBootIntro.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class EmployeeEntity {

    @Id  // It is basically the to define the primary Key Neeche wala hmko autogenerate krke dega
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter
    @Getter
    private Long id;

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private String email;

    @Getter
    @Setter
    private Integer age;

    @Setter
    @Getter
    private LocalDate dateOfJoining;

    private Boolean isActive;
}
