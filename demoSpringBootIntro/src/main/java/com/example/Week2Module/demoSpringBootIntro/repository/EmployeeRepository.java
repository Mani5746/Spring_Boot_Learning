package com.example.Week2Module.demoSpringBootIntro.repository;

import com.example.Week2Module.demoSpringBootIntro.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {

}
