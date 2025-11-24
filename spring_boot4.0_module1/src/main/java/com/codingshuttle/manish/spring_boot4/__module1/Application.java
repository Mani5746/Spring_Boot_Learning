package com.codingshuttle.manish.spring_boot4.__module1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	PaymentService paymentService;

	public static void main(String[] args)  {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		paymentService.pay();
	}

	@PostConstruct
	public void AfterInit(){
		System.out.println("Before Payment");
	}

	@PreDestroy
	public void BeforeDestroy(){
		System.out.println("Payment is Done");
	}
}
