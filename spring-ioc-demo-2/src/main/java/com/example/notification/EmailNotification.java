package com.example.notification;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component("emailBean")   // Custom Bean Name
public class EmailNotification implements Notification {

    public EmailNotification() {
        System.out.println("EmailNotification Bean Created");
    }

    @PostConstruct
    public void init() {
        System.out.println("EmailNotification Bean Initialized");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("EmailNotification Bean Destroyed");
    }

    @Override
    public void send(String message) {
        System.out.println("Email Notification sent: " + message);
    }
}