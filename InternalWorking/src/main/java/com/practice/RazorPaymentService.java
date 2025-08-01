package com.practice;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "payment.provider", havingValue = "razorpay")
public class RazorPaymentService implements PaymentService {

    public String pay() {
        String payment = "Razorpay";
        System.out.println("payment from: " + payment);
        return payment;
    }


}
