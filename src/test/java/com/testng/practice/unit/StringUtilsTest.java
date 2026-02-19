package com.testng.practice.unit;

import org.testng.annotations.*;
import static org.testng.Assert.*;
import com.testng.practice.utils.StringUtils;

/**
 * Unit tests for StringUtils class
 */
public class StringUtilsTest {

    @Test(description = "Test isEmpty with null string")
    public void testIsEmptyWithNull() {
        assertTrue(StringUtils.isEmpty(null), "Null string should be empty");
    }

    @Test(description = "Test isEmpty with empty string")
    public void testIsEmptyWithEmptyString() {
        assertTrue(StringUtils.isEmpty(""), "Empty string should be empty");
    }

    @Test(description = "Test isEmpty with whitespace")
    public void testIsEmptyWithWhitespace() {
        assertTrue(StringUtils.isEmpty("   "), "Whitespace string should be empty");
    }

    @Test(description = "Test isEmpty with non-empty string")
    public void testIsEmptyWithNonEmptyString() {
        assertFalse(StringUtils.isEmpty("TestNG"), "Non-empty string should not be empty");
    }

    @Test(description = "Test capitalize")
    public void testCapitalize() {
        String result = StringUtils.capitalize("testng");
        assertEquals(result, "Testng", "First letter should be capitalized");
    }

    @Test(description = "Test reverse")
    public void testReverse() {
        String result = StringUtils.reverse("TestNG");
        assertEquals(result, "GNtseT", "String should be reversed");
    }
}
