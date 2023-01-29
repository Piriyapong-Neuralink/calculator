package com.example.demo.service;


import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class CalculationService {
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter localDateTimeFormated = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    String formatDateTime = now.format(localDateTimeFormated);

    CalculationService () {

    }
    public float getPlus(float first, float second) {
        float result = first + second;
        System.out.println("number1: " + first);
        System.out.println("number2: " + second);
        System.out.println("operation: Plus");
        System.out.println("result: " + result);
        System.out.println("timestamp: " + formatDateTime);
        System.out.println("----------------");
        return result;
    }

    public float getMinus(float first, float second) {
        float result = first - second;
        System.out.println("number1: " + first);
        System.out.println("number2: " + second);
        System.out.println("operation: Minus");
        System.out.println("result: " + result);
        System.out.println("timestamp: " + formatDateTime);
        System.out.println("----------------");
        return result;
    }

    public float getMultiply(float first, float second) {
        float result = first * second;
        System.out.println("number1: " + first);
        System.out.println("number2: " + second);
        System.out.println("operation: Multiply");
        System.out.println("result: " + result);
        System.out.println("timestamp: " + formatDateTime);
        System.out.println("----------------");
        return result;
    }

    public float getDivide(float first, float second) {
        float result = first / second;
        System.out.println("number1: " + first);
        System.out.println("number2: " + second);
        System.out.println("operation: Divide");
        System.out.println("result: " + result);
        System.out.println("timestamp: " + formatDateTime);
        System.out.println("----------------");
        if(Float.isNaN(result)) {
            throw new IllegalArgumentException("Division of zero by zero.");
        }
        return result;
    }

}
