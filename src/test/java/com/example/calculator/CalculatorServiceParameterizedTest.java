package com.example.calculator;

import com.example.calculator.service.CalculatorService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorServiceParameterizedTest {

    @Autowired
    private CalculatorService calculatorService;

    @ParameterizedTest
    @CsvSource({
            "5, 5, 10",
            "0, 0, 0",
            "-5, 5, 0"
    })
    public void testAdd(int a, int b, int expected) {
        assertEquals(expected, calculatorService.add(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "5, 5, 0",
            "0, 5, -5",
            "-5, 5, -10"
    })
    public void testSubtract(int a, int b, int expected) {
        assertEquals(expected, calculatorService.subtract(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "5, 5, 25",
            "0, 5, 0",
            "-5, 5, -25"
    })
    public void testMultiply(int a, int b, int expected) {
        assertEquals(expected, calculatorService.multiply(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "5, 5, 1",
            "0, 5, 0",
            "-5, 5, -1"
    })
    public void testDivide(int a, int b, int expected) {
        assertEquals(expected, calculatorService.divide(a, b));
    }
}