package com.codingshuttle.manish.spring_boot4.__module1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    PaymentService paymentService (){

        return new PaymentService();
    }


}
