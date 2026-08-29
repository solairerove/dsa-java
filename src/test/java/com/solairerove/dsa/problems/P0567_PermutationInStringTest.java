package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static com.solairerove.dsa.problems.P0567_PermutationInString.checkInclusion;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("NewClassNamingConvention")
class P0567_PermutationInStringTest {

    @Test
    void permutationAtStart() {
        assertTrue(checkInclusion("ab", "eidbaooo"));
    }

    @Test
    void noPermutation() {
        assertFalse(checkInclusion("ab", "eidboaoo"));
    }

    @Test
    void exactMatch() {
        assertTrue(checkInclusion("abc", "abc"));
    }

    @Test
    void s1LongerThanS2() {
        assertFalse(checkInclusion("abcd", "abc"));
    }

    @Test
    void singleCharPresent() {
        assertTrue(checkInclusion("a", "a"));
    }

    @Test
    void singleCharAbsent() {
        assertFalse(checkInclusion("a", "b"));
    }

    @Test
    void permutationAtEnd() {
        assertTrue(checkInclusion("adc", "dcda"));
    }

    @Test
    void repeatedCharsNeedCorrectCounts() {
        assertFalse(checkInclusion("aab", "abbab"));
    }

    @Test
    void repeatedCharsMatch() {
        assertTrue(checkInclusion("aab", "xyzaabq"));
    }

    @Test
    void repeatedCharsMismatchOrder() {
        assertFalse(checkInclusion("aab", "bbabb"));
    }

    @Test
    void allSameChars() {
        assertTrue(checkInclusion("aaa", "aaaa"));
    }

    @Test
    void notEnoughRepeats() {
        assertFalse(checkInclusion("aaa", "aabaa"));
    }

    @Test
    void windowSlidesPastFalseStart() {
        assertTrue(checkInclusion("hello", "ooolleohellx"));
    }

    @Test
    void longS2NoMatch() {
        assertFalse(checkInclusion("abc", "cccccbbbbbaaaaa"));
    }
}
