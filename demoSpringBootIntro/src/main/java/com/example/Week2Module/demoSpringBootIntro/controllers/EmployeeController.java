package com.example.Week2Module.demoSpringBootIntro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class EmployeeController {
  @GetMapping(path = "/getSecretMessage")
    public String getMySuperSecretMessage(){
      return "Secret message: hjnkmngbd23454";
  }
}
