package com.example;

import com.example.config.AppConfig;
import com.example.payment.Payment;
import com.example.payment.UpiPayment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Payment payment = context.getBean(Payment.class);
        payment.pay(5000);

        UpiPayment upi1 = context.getBean(UpiPayment.class);
        UpiPayment upi2 = context.getBean(UpiPayment.class);

        System.out.println("Are both UPI beans same? " + (upi1 == upi2));

        context.close();
    }
}