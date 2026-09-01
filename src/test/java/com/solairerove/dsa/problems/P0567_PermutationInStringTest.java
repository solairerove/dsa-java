package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static com.solairerove.dsa.problems.P0567_PermutationInString.checkInclusion;
import static com.solairerove.dsa.problems.P0567_PermutationInString.checkInclusionRequired;
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

    @Test
    void permutationAtStartRequired() {
        assertTrue(checkInclusionRequired("ab", "eidbaooo"));
    }

    @Test
    void noPermutationRequired() {
        assertFalse(checkInclusionRequired("ab", "eidboaoo"));
    }

    @Test
    void exactMatchRequired() {
        assertTrue(checkInclusionRequired("abc", "abc"));
    }

    @Test
    void s1LongerThanS2Required() {
        assertFalse(checkInclusionRequired("abcd", "abc"));
    }

    @Test
    void singleCharPresentRequired() {
        assertTrue(checkInclusionRequired("a", "a"));
    }

    @Test
    void singleCharAbsentRequired() {
        assertFalse(checkInclusionRequired("a", "b"));
    }

    @Test
    void permutationAtEndRequired() {
        assertTrue(checkInclusionRequired("adc", "dcda"));
    }

    @Test
    void repeatedCharsNeedCorrectCountsRequired() {
        assertFalse(checkInclusionRequired("aab", "abbab"));
    }

    @Test
    void repeatedCharsMatchRequired() {
        assertTrue(checkInclusionRequired("aab", "xyzaabq"));
    }

    @Test
    void repeatedCharsMismatchOrderRequired() {
        assertFalse(checkInclusionRequired("aab", "bbabb"));
    }

    @Test
    void allSameCharsRequired() {
        assertTrue(checkInclusionRequired("aaa", "aaaa"));
    }

    @Test
    void notEnoughRepeatsRequired() {
        assertFalse(checkInclusionRequired("aaa", "aabaa"));
    }

    @Test
    void windowSlidesPastFalseStartRequired() {
        assertTrue(checkInclusionRequired("hello", "ooolleohellx"));
    }

    @Test
    void longS2NoMatchRequired() {
        assertFalse(checkInclusionRequired("abc", "cccccbbbbbaaaaa"));
    }
}
