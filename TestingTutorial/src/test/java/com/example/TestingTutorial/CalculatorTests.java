package com.example.TestingTutorial;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculatorTests {
//    Calculator c = new Calculator();
        @Autowired Calculator c;

    @BeforeAll
    public static void setup() {
        System.out.println("Setup function");
    }

    @BeforeEach
    public void beforeEveryTest(){
        System.out.println("Executed before the test");
    }

    @Test
    public void testAdd_When_Numbers_are_positive() {
        int a = 10;
        int b = 20;
        int expected = 30;
        int actual = c.add(a,b);
        System.out.println("Test 1");
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void testSubtract() {
        int a = 5;
        int b = 3;
        int expected = 2;
        int actual = c.subtract(a,b);
        System.out.println("Test 2");
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void testIsEven_When_number_is_odd() {
        boolean actual = c.isEven(15);
        System.out.println("Test 3");
        Assertions.assertFalse(actual);
    }

    @Test
    public void testIsEven_When_number_is_even() {
        boolean actual = c.isEven(16);
        System.out.println("Test 4");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testSumManyNumbers() {
        int actual = c.sumManyNumbers(1,2,3,4);
        int expected = 10;
        System.out.println("Test 5");
        Assertions.assertEquals(expected,actual);
    }

    @AfterEach
    public void afterEveryTest() {
        System.out.println("Excuted after every test");
    }

    @AfterAll
    public static void cleanup() {
        System.out.println("Cleanup function");
    }
}
