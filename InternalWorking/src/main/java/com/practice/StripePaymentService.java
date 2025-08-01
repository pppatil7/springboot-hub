package com.practice;

import org.springframework.stereotype.Component;

@Component
public class StripePaymentService implements PaymentService {

    @Override
    public String pay() {
        String payment = "Stripe";
        System.out.println("payment from: " + payment);
        return payment;
    }
}
