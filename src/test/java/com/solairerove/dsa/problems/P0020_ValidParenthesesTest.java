package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static com.solairerove.dsa.problems.P0020_ValidParentheses.isValid;
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
}
