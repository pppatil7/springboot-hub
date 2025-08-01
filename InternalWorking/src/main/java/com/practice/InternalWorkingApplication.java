package com.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InternalWorkingApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(InternalWorkingApplication.class, args);
    }

    //   @Autowired
    private final RazorPaymentService paymentService;

    public InternalWorkingApplication(RazorPaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    public void run(String... args) throws Exception {
        String payment = paymentService.pay();
        System.out.println("Payment Done.. " + payment);
    }
}
