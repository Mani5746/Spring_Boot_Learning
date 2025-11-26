package com.codingshuttle.manish.spring_boot4.__module1;

import com.codingshuttle.manish.spring_boot4.__module1.Impl.Email_Notifications;
import com.codingshuttle.manish.spring_boot4.__module1.Impl.SMSNotifications;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
	//@Autowired
	Notification_Service notificationService;


  public Application( //@Qualifier("emailnotif")
					 Notification_Service notificationService){
	  this.notificationService=notificationService;  // Constructor DI  Most Preferred
  }
	public static void main(String[] args)  {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	//	notificationService=new SMSNotifications();

		 notificationService.send("Hello");
		}
	}



