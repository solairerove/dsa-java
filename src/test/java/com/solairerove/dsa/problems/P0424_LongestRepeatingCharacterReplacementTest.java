package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static com.solairerove.dsa.problems.P0424_LongestRepeatingCharacterReplacement.characterReplacement;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0424_LongestRepeatingCharacterReplacementTest {

    @Test
    void shouldSolveExampleOne() {
        assertEquals(4, characterReplacement("ABAB", 2));
    }

    @Test
    void shouldSolveExampleTwo() {
        assertEquals(4, characterReplacement("AABABBA", 1));
    }

    @Test
    void shouldReturnZeroOnEmptyString() {
        assertEquals(0, characterReplacement("", 2));
    }

    @Test
    void shouldReturnOneOnSingleChar() {
        assertEquals(1, characterReplacement("A", 0));
    }

    @Test
    void shouldReturnLengthWhenAllSame() {
        assertEquals(5, characterReplacement("AAAAA", 0));
    }

    @Test
    void shouldReturnLongestRunWhenNoReplacementsAllowed() {
        assertEquals(3, characterReplacement("ABBBCC", 0));
    }

    @Test
    void shouldCoverWholeStringWhenKExceedsLength() {
        assertEquals(4, characterReplacement("ABCD", 10));
    }

    @Test
    void shouldHandleAllDistinctWithOneReplacement() {
        assertEquals(2, characterReplacement("ABCDE", 1));
    }

    @Test
    void shouldHandleReplacementsInMiddle() {
        assertEquals(5, characterReplacement("AABBBAA", 2));
    }

    @Test
    void shouldHandleLongerMixedString() {
        assertEquals(4, characterReplacement("ABAABBBA", 1));
    }
}
