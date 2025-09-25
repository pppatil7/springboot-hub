package com.practice;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


@Slf4j
class TestingAppApplicationTests {

//    @BeforeAll
//    static void setUpOnce() {
//        log.info("setup once");
//    }

    @BeforeEach
    void setUp() {
        log.info("starting the method, setting up config");
    }

    @AfterEach
    void tearDown() {
        log.info("Tearing down the method");
    }

//    @AfterAll
//    static void tearDownOnce() {
//        log.info("Tearing down all");
//    }

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

    @Test
    void testDivideTwoNumbersWhen_DenominatorIsZero_ThenArithmeticException() {
        int a = 5;
        int b = 0;

        assertThatThrownBy(() -> divideTwoNumbers(a, b))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Tried to divide by Zero");

    }

    private int addTwoNumbers(int a, int b) {
        return a + b;
    }

    double divideTwoNumbers(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            log.error("Arithmetic exception occured: " + e.getLocalizedMessage());
            throw new ArithmeticException("Tried to divide by Zero");
        }
    }


}
