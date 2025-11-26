package com.codingshuttle.manish.spring_boot4.__module1.Impl;

import com.codingshuttle.manish.spring_boot4.__module1.Notification_Service;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
@Qualifier("emailnotif")
@ConditionalOnProperty(name = "notification.type",havingValue="email")
public class Email_Notifications implements Notification_Service {

    @Override
    public void send(String msg) {
        System.out.println("Email is running....." +msg);
    }
}
