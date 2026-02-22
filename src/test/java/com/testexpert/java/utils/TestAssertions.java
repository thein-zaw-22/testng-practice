package com.testexpert.java.utils;

import org.testng.Assert;

/**
 * Test fixture and helper utilities
 */
public class TestAssertions {

    public static void assertGreaterThan(int actual, int expected, String message) {
        Assert.assertTrue(actual > expected, message);
    }

    public static void assertLessThan(int actual, int expected, String message) {
        Assert.assertTrue(actual < expected, message);
    }

    public static void assertBetween(int value, int min, int max, String message) {
        Assert.assertTrue(value >= min && value <= max, message);
    }
}
