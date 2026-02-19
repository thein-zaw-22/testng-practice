package com.testng.practice.unit;

import org.testng.annotations.*;
import static org.testng.Assert.*;
import com.testng.practice.app.Calculator;

/**
 * Unit tests for Calculator class
 */
public class CalculatorTest {

    private Calculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

    @Test(description = "Test addition")
    public void testAddition() {
        int result = calculator.add(5, 3);
        assertEquals(result, 8, "5 + 3 should equal 8");
    }

    @Test(description = "Test subtraction")
    public void testSubtraction() {
        int result = calculator.subtract(10, 4);
        assertEquals(result, 6, "10 - 4 should equal 6");
    }

    @Test(description = "Test multiplication")
    public void testMultiplication() {
        int result = calculator.multiply(4, 5);
        assertEquals(result, 20, "4 * 5 should equal 20");
    }

    @Test(description = "Test division")
    public void testDivision() {
        double result = calculator.divide(10, 2);
        assertEquals(result, 5.0, "10 / 2 should equal 5.0");
    }

    @Test(description = "Test division by zero throws exception", expectedExceptions = IllegalArgumentException.class)
    public void testDivisionByZero() {
        calculator.divide(10, 0);
    }

    @AfterMethod
    public void tearDown() {
        calculator = null;
    }
}
