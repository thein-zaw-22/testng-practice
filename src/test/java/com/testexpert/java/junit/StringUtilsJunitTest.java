package com.testexpert.java.junit;

import com.testexpert.java.utils.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("StringUtils unit tests with JUnit 5")
class StringUtilsJunitTest {

    @ParameterizedTest(name = "isEmpty('{0}') should be {1}")
    @CsvSource(value = {
            "'', true",
            "'   ', true",
            "'test', false"
    })
    void isEmptyCoversCommonCases(String input, boolean expected) {
        assertEquals(expected, StringUtils.isEmpty(input));
    }

    @Test
    @DisplayName("capitalize uppercases first character")
    void capitalizeUppercasesFirstCharacter() {
        assertEquals("Hello", StringUtils.capitalize("hello"));
    }

    @Test
    @DisplayName("reverse inverts string")
    void reverseInvertsString() {
        assertEquals("cba", StringUtils.reverse("abc"));
    }

    @Test
    @DisplayName("isEmpty returns true for null")
    void isEmptyHandlesNull() {
        assertTrue(StringUtils.isEmpty(null));
    }
}
