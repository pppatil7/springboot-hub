package com.practice;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;


@Slf4j
class TestingAppApplicationTests {

    @BeforeAll
    static void setUpOnce() {
        log.info("setup once");
    }

    @BeforeEach
    void setUp() {
        log.info("starting the method, setting up config");
    }

    @AfterEach
    void tearDown() {
        log.info("Tearing down the method");
    }

    @AfterAll
    static void tearDownOnce() {
        log.info("Tearing down all");
    }

    @Test
    void testNumberOne() {
        log.info("test one");
    }

    @Test
    void testNumberTwo() {
        int a = 12;
        int b = 45;

        int result = addTwoNumbers(a, b);

        Assertions.assertEquals(57, result);

    }

    private int addTwoNumbers(int a, int b) {
        return a + b;
    }


}
