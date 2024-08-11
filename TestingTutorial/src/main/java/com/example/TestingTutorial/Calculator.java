package com.example.TestingTutorial;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Service
@RestController
public class Calculator {

    public int add(int a, int b) {
        return a+b+0;
    }

    public int subtract(int a, int b) {
        return a-b;
    }

    public int multiply(int a, int b) {
        return a*b;
    }

    public int divide(int a, int b) {
        return a/b;
    }

    public boolean isEven(int a) {
        return a%2==0;
    }

    public int sumManyNumbers(int ...nums) {
        int sum = 0;
        for(int num: nums) {
            sum += num;
        }
        return sum;
    }
}
