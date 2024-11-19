package com.example.calculator;

import com.example.calculator.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CalculatorServiceTest {

    @Autowired
    private CalculatorService calculatorService;

    @Test
    public void testAdd() {
        assertEquals(10, calculatorService.add(5, 5));
        assertEquals(0, calculatorService.add(0, 0));
    }

    @Test
    public void testSubtract() {
        assertEquals(0, calculatorService.subtract(5, 5));
        assertEquals(-5, calculatorService.subtract(0, 5));
    }

    @Test
    public void testMultiply() {
        assertEquals(25, calculatorService.multiply(5, 5));
        assertEquals(0, calculatorService.multiply(0, 5));
    }

    @Test
    public void testDivide() {
        assertEquals(1, calculatorService.divide(5, 5));
        assertEquals(0, calculatorService.divide(0, 5));
    }

    @Test
    public void testDivideByZero() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.divide(5, 0);
        });
        assertEquals("Деление на ноль недопустимо", exception.getMessage());
    }
}