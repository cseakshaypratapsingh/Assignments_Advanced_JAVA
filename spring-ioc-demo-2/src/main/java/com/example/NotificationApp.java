package com.example;

import com.example.config.AppConfig;
import com.example.notification.Notification;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class NotificationApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("Container Started");

        Notification email =
                (Notification) context.getBean("emailBean");
        email.send("Welcome User!");

        Notification sms =
                (Notification) context.getBean("smsBean");
        sms.send("OTP 1234");

        context.close();
    }
}