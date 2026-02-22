package com.testexpert.java.junit;

import com.testexpert.java.app.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Calculator unit tests with JUnit 5")
class CalculatorJunitTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("add returns the sum")
    void addReturnsSum() {
        assertEquals(8, calculator.add(5, 3));
    }

    @Test
    @DisplayName("divide returns decimal result")
    void divideReturnsResult() {
        assertEquals(2.5, calculator.divide(5, 2));
    }

    @Test
    @DisplayName("divide by zero throws IllegalArgumentException")
    void divideByZeroThrows() {
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(10, 0));
    }
}
