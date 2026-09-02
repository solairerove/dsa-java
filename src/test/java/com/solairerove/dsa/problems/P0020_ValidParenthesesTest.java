package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static com.solairerove.dsa.problems.P0020_ValidParentheses.isValid;
import static com.solairerove.dsa.problems.P0020_ValidParentheses.isValidArray;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("NewClassNamingConvention")
class P0020_ValidParenthesesTest {

    @Test
    void example1() {
        assertTrue(isValid("()"));
    }

    @Test
    void example2() {
        assertTrue(isValid("()[]{}"));
    }

    @Test
    void example3() {
        assertFalse(isValid("(]"));
    }

    @Test
    void nested() {
        assertTrue(isValid("{[()]}"));
    }

    @Test
    void wrongOrder() {
        assertFalse(isValid("([)]"));
    }

    @Test
    void unclosedOpen() {
        assertFalse(isValid("((("));
    }

    @Test
    void onlyClosing() {
        assertFalse(isValid(")"));
    }

    @Test
    void emptyString() {
        assertTrue(isValid(""));
    }

    @Test
    void longValid() {
        assertTrue(isValid("({[]})[]{()}"));
    }

    @Test
    void trailingClose() {
        assertFalse(isValid("(){}}{"));
    }
    @Test
    void example1Array() {
        assertTrue(isValidArray("()"));
    }

    @Test
    void example2Array() {
        assertTrue(isValidArray("()[]{}"));
    }

    @Test
    void example3Array() {
        assertFalse(isValidArray("(]"));
    }

    @Test
    void nestedArray() {
        assertTrue(isValidArray("{[()]}"));
    }

    @Test
    void wrongOrderArray() {
        assertFalse(isValidArray("([)]"));
    }

    @Test
    void unclosedOpenArray() {
        assertFalse(isValidArray("((("));
    }

    @Test
    void onlyClosingArray() {
        assertFalse(isValidArray(")"));
    }

    @Test
    void emptyStringArray() {
        assertTrue(isValidArray(""));
    }

    @Test
    void longValidArray() {
        assertTrue(isValidArray("({[]})[]{()}"));
    }

    @Test
    void trailingCloseArray() {
        assertFalse(isValidArray("(){}}{"));
    }
}
