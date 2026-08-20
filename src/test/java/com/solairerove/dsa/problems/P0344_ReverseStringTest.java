package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static com.solairerove.dsa.problems.P0344_ReverseString.reverseString;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0344_ReverseStringTest {

    @Test
    void shouldReverseExampleOne() {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        assertArrayEquals(new char[]{'o', 'l', 'l', 'e', 'h'}, s);
    }

    @Test
    void shouldReverseExampleTwo() {
        char[] s = {'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString(s);
        assertArrayEquals(new char[]{'h', 'a', 'n', 'n', 'a', 'H'}, s);
    }

    @Test
    void shouldHandleSingleCharacter() {
        char[] s = {'a'};
        reverseString(s);
        assertArrayEquals(new char[]{'a'}, s);
    }

    @Test
    void shouldHandleTwoCharacters() {
        char[] s = {'a', 'b'};
        reverseString(s);
        assertArrayEquals(new char[]{'b', 'a'}, s);
    }

    @Test
    void shouldHandleEmptyArray() {
        char[] s = {};
        reverseString(s);
        assertArrayEquals(new char[]{}, s);
    }

    @Test
    void shouldHandlePalindrome() {
        char[] s = {'r', 'a', 'c', 'e', 'c', 'a', 'r'};
        reverseString(s);
        assertArrayEquals(new char[]{'r', 'a', 'c', 'e', 'c', 'a', 'r'}, s);
    }

    @Test
    void shouldHandleRepeatedCharacters() {
        char[] s = {'a', 'a', 'a', 'a'};
        reverseString(s);
        assertArrayEquals(new char[]{'a', 'a', 'a', 'a'}, s);
    }

    @Test
    void shouldHandleDigitsAndSymbols() {
        char[] s = {'1', '2', '!', '@'};
        reverseString(s);
        assertArrayEquals(new char[]{'@', '!', '2', '1'}, s);
    }

    @Test
    void shouldHandleEvenLengthMixedCase() {
        char[] s = {'A', 'b', 'C', 'd'};
        reverseString(s);
        assertArrayEquals(new char[]{'d', 'C', 'b', 'A'}, s);
    }

    @Test
    void shouldBeIdentityWhenAppliedTwice() {
        char[] s = {'c', 'l', 'a', 'u', 'd', 'e'};
        reverseString(s);
        reverseString(s);
        assertArrayEquals(new char[]{'c', 'l', 'a', 'u', 'd', 'e'}, s);
    }
}
