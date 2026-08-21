package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static com.solairerove.dsa.problems.P0125_ValidPalindrome.isPalindrome;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("NewClassNamingConvention")
class P0125_ValidPalindromeTest {

    @Test
    void shouldAcceptExampleOne() {
        assertTrue(isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    void shouldRejectExampleTwo() {
        assertFalse(isPalindrome("race a car"));
    }

    @Test
    void shouldAcceptSingleSpace() {
        assertTrue(isPalindrome(" "));
    }

    @Test
    void shouldAcceptEmptyString() {
        assertTrue(isPalindrome(""));
    }

    @Test
    void shouldAcceptSingleCharacter() {
        assertTrue(isPalindrome("a"));
    }

    @Test
    void shouldAcceptOnlyNonAlphanumeric() {
        assertTrue(isPalindrome(".,!?;:"));
    }

    @Test
    void shouldAcceptDigitsPalindrome() {
        assertTrue(isPalindrome("12321"));
    }

    @Test
    void shouldRejectDigitsNonPalindrome() {
        assertFalse(isPalindrome("12345"));
    }

    @Test
    void shouldAcceptMixedLettersAndDigits() {
        assertTrue(isPalindrome("0P0"));
    }

    @Test
    void shouldRejectLetterVersusDigit() {
        assertFalse(isPalindrome("0P"));
    }

    @Test
    void shouldIgnoreCase() {
        assertTrue(isPalindrome("AbBa"));
    }

    @Test
    void shouldRejectNearPalindrome() {
        assertFalse(isPalindrome("abca"));
    }

    @Test
    void shouldAcceptOddLengthWithPunctuation() {
        assertTrue(isPalindrome("Was it a car or a cat I saw?"));
    }

    @Test
    void shouldRejectTwoDifferentCharacters() {
        assertFalse(isPalindrome("ab"));
    }
}
