package com.example.demo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculationServiceTest {
    @Autowired
    CalculationService service;

    @Test
    void plusSuccess() {
        float number1 = 20;
        float number2 = 20;
        float result = service.getPlus(number1, number2);
        Assertions.assertEquals(40, result);
    }

    @Test
    void minusSuccess() {
        float number1 = 20;
        float number2 = 20;
        float result = service.getMinus(number1, number2);
        Assertions.assertEquals(0, result);
    }

    @Test
    void multiplySuccess() {
        float number1 = 20;
        float number2 = 20;
        float result = service.getMultiply(number1, number2);
        Assertions.assertEquals(400, result);
    }

    @Test
    void divineSuccess() {
        float number1 = 20;
        float number2 = 20;
        float result = service.getDivide(number1, number2);
        Assertions.assertEquals(1, result);
    }
}
