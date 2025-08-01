package com.practice;

public class RazorPaymentService implements PaymentService {

    public String pay() {
        String payment = "Razorpay";
        System.out.println("payment from: " + payment);
        return payment;
    }


}
