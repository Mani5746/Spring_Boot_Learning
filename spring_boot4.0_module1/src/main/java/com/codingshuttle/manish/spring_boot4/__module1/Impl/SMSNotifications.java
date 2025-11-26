package com.codingshuttle.manish.spring_boot4.__module1.Impl;

import com.codingshuttle.manish.spring_boot4.__module1.Notification_Service;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@Qualifier("smsnotif")
@ConditionalOnProperty(name = "notification.type",havingValue="sms")
public class SMSNotifications implements Notification_Service {

    @Override
    public void send(String msg) {
        System.out.println("SMS is running......" + msg);
    }
}
