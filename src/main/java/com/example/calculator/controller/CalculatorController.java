package com.example.calculator.controller;

import com.example.calculator.service.CalculatorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @RequestMapping
    public String welcome() {
        return "Добро пожаловать в калькулятор";
    }

    @RequestMapping("/plus")
    public String plus(@RequestParam int num1, @RequestParam int num2) {
        int result = calculatorService.add(num1, num2);
        return String.format("%d + %d = %d", num1, num2, result);
    }

    @RequestMapping("/minus")
    public String minus(@RequestParam int num1, @RequestParam int num2) {
        int result = calculatorService.subtract(num1, num2);
        return String.format("%d - %d = %d", num1, num2, result);
    }

    @RequestMapping("/multiply")
    public String multiply(@RequestParam int num1, @RequestParam int num2) {
        int result = calculatorService.multiply(num1, num2);
        return String.format("%d * %d = %d", num1, num2, result);
    }

    @RequestMapping("/divide")
    public String divide(@RequestParam int num1, @RequestParam int num2) {
        if (num2 == 0) {
            return "Ошибка: деление на ноль";
        }
        int result = calculatorService.divide(num1, num2);
        return String.format("%d / %d = %d", num1, num2, result);
    }
}