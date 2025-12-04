package com.example.Week2Module.demoSpringBootIntro.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class EmployeeDTO {

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

    public EmployeeDTO(){

    }

    public EmployeeDTO(Long id, String name, String email, Integer age, LocalDate dateOfJoining, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.dateOfJoining = dateOfJoining;
        this.isActive = isActive;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
