package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static com.solairerove.dsa.problems.P0680_ValidPalindromeII.validPalindrome;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("NewClassNamingConvention")
class P0680_ValidPalindromeIITest {

    @Test
    void shouldAcceptExampleOne() {
        assertTrue(validPalindrome("aba"));
    }

    @Test
    void shouldAcceptExampleTwo() {
        assertTrue(validPalindrome("abca"));
    }

    @Test
    void shouldRejectExampleThree() {
        assertFalse(validPalindrome("abc"));
    }

    @Test
    void shouldAcceptEmptyString() {
        assertTrue(validPalindrome(""));
    }

    @Test
    void shouldAcceptSingleCharacter() {
        assertTrue(validPalindrome("a"));
    }

    @Test
    void shouldAcceptTwoDifferentCharacters() {
        assertTrue(validPalindrome("ab"));
    }

    @Test
    void shouldAcceptAlreadyPalindromeEvenLength() {
        assertTrue(validPalindrome("abba"));
    }

    @Test
    void shouldAcceptDeletionFromLeft() {
        assertTrue(validPalindrome("cbbcc"));
    }

    @Test
    void shouldAcceptDeletionFromRight() {
        assertTrue(validPalindrome("ccbbc"));
    }

    @Test
    void shouldRejectWhenTwoDeletionsNeeded() {
        assertFalse(validPalindrome("abcdef"));
    }

    @Test
    void shouldRejectMismatchDeepInside() {
        assertFalse(validPalindrome("abcdxeba"));
    }

    @Test
    void shouldAcceptAllSameCharacters() {
        assertTrue(validPalindrome("aaaaa"));
    }

    @Test
    void shouldAcceptExtraCharacterInMiddle() {
        assertTrue(validPalindrome("racecarx"));
    }

    @Test
    void shouldRejectWhenBothOuterDeletionsFail() {
        assertFalse(validPalindrome("cabbad"));
    }
}
