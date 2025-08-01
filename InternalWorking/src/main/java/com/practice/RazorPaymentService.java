package com.practice;

import org.springframework.stereotype.Component;

@Component
public class RazorPaymentService {

    public String pay() {
        String payment = "Razorpay";
        System.out.println("payment from: " + payment);
        return payment;
    }


}
