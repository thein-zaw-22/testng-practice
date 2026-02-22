package com.testexpert.java.integration;

import org.testng.annotations.*;
import static org.testng.Assert.*;
import com.testexpert.java.app.Calculator;
import com.testexpert.java.utils.StringUtils;

/**
 * Integration tests combining multiple components
 */
public class CalculatorIntegrationTest {

    private Calculator calculator;

    @BeforeTest
    public void setUp() {
        System.out.println("Setting up integration test environment");
        calculator = new Calculator();
    }

    @Test(description = "Integration: Test calculator and string utils together")
    public void testCalculatorWithStringUtils() {
        int result = calculator.add(5, 3);
        String resultString = String.valueOf(result);
        assertFalse(StringUtils.isEmpty(resultString), "Result string should not be empty");
        assertEquals(resultString, "8", "String result should be 8");
    }

    @Test(description = "Integration: Test multiple calculator operations")
    public void testChainedCalculations() {
        int add = calculator.add(10, 5); // 15
        int multiply = calculator.multiply(add, 2); // 30
        int subtract = calculator.subtract(multiply, 5); // 25
        assertEquals(subtract, 25, "Chained calculations should equal 25");
    }

    @AfterTest
    public void tearDown() {
        System.out.println("Cleaning up integration test environment");
        calculator = null;
    }
}
