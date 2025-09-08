package com.practice;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

public class Mango {

    void eat() {
        System.out.println("Eating mango");
    }

    @PostConstruct
    void callThisBeforeMangoIsUsed() {
        System.out.println("creating the mango before use");
    }

    @PreDestroy
    void callThisBeforeDestroy() {
        System.out.println("destroying the mango bean");
    }
}
