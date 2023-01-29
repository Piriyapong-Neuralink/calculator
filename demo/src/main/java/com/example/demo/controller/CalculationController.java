package com.example.demo.controller;

import com.example.demo.service.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("calculator/v1")
public class CalculationController {

    private CalculationService calculationService;

    @Autowired
    public CalculationController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @GetMapping("plus")
    public ResponseEntity<Float> plus(
        @RequestParam(value = "number1", required = true) float first,
        @RequestParam(value = "number2", required = true) float second
    ) {
        float result = calculationService.getPlus(first, second);
        //Handle result with ObjectUtils.isEmpty
        return !ObjectUtils.isEmpty(result) ? ResponseEntity.ok(result) : ResponseEntity.notFound().build();
    }

    @GetMapping("minus")
    public ResponseEntity<Float> minus(
            @RequestParam(value = "number1", required = true) float first,
            @RequestParam(value = "number2", required = true) float second
    ) {
        float result = calculationService.getMinus(first, second);
        //Handle result with ObjectUtils.isEmpty
        return !ObjectUtils.isEmpty(result) ? ResponseEntity.ok(result) : ResponseEntity.notFound().build();
    }

    @GetMapping("multiply")
    public ResponseEntity<Float> multiply(
            @RequestParam(value = "number1", required = true) float first,
            @RequestParam(value = "number2", required = true) float second
    ) {
        float result = calculationService.getMultiply(first, second);
        //Handle result with ObjectUtils.isEmpty
        return !ObjectUtils.isEmpty(result) ? ResponseEntity.ok(result) : ResponseEntity.notFound().build();
    }

    @GetMapping("divide")
    public ResponseEntity<Float> divide(
            @RequestParam(value = "number1", required = true) float first,
            @RequestParam(value = "number2", required = true) float second
    ) {
        float result = calculationService.getDivide(first, second);
        //Handle result with ObjectUtils.isEmpty
        return !ObjectUtils.isEmpty(result) ? ResponseEntity.ok(result) : ResponseEntity.notFound().build();
    }
}