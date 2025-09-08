package com.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootBasicApplication implements CommandLineRunner {

    @Autowired
    Mango mango1;

    @Autowired
    Mango mango2;


    public static void main(String[] args) {
        SpringApplication.run(SpringBootBasicApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        mango1.eat();
        mango2.eat();
        System.out.println(mango1.hashCode());
        System.out.println(mango2.hashCode());
    }
}
