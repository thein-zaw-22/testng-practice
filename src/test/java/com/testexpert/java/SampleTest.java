package com.testexpert.java;

import org.testng.annotations.*;
import static org.testng.Assert.*;

/**
 * Sample test class demonstrating TestNG annotations and assertions
 */
public class SampleTest {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite: Initializing test suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test: Setting up test");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before Class: Initializing test class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method: Setting up test method");
    }

    @Test(description = "Test 1: Verify basic assertion")
    public void testOne() {
        System.out.println("Executing Test One");
        assertTrue(true, "This should pass");
    }

    @Test(description = "Test 2: Verify string comparison")
    public void testTwo() {
        System.out.println("Executing Test Two");
        assertEquals("TestNG", "TestNG", "Strings should match");
    }

    @Test(description = "Test 3: Verify arithmetic", enabled = true)
    public void testThree() {
        System.out.println("Executing Test Three");
        int result = 5 + 5;
        assertEquals(result, 10, "5 + 5 should equal 10");
    }

    @Test(description = "Test 4: Verify array contents")
    public void testFour() {
        System.out.println("Executing Test Four");
        int[] numbers = {1, 2, 3, 4, 5};
        assertEquals(numbers.length, 5, "Array length should be 5");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method: Cleaning up after test method");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After Class: Cleaning up test class");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test: Cleaning up test");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite: Finalizing test suite");
    }
}
