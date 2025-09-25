package com.practice;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


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
        assertThat("Mango").startsWith("Man").endsWith("go").hasSize(5);
    }

    @Test
    void testNumberTwo() {
        int a = 12;
        int b = 45;

        int result = addTwoNumbers(a, b);

//        Assertions.assertEquals(57, result);

        assertThat(result).isEqualTo(57)
                .isCloseTo(58, Offset.offset(1));


    }

    private int addTwoNumbers(int a, int b) {
        return a + b;
    }


}
