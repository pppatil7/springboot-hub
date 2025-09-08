package com.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootBasicApplication implements CommandLineRunner {

    @Autowired
    Mango mango;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBasicApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        mango.eat();
    }
}
