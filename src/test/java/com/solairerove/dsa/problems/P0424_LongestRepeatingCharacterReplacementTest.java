package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static com.solairerove.dsa.problems.P0424_LongestRepeatingCharacterReplacement.characterReplacement;
import static com.solairerove.dsa.problems.P0424_LongestRepeatingCharacterReplacement.characterReplacementMap;
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
    @Test
    void shouldSolveExampleOneMap() {
        assertEquals(4, characterReplacementMap("ABAB", 2));
    }

    @Test
    void shouldSolveExampleTwoMap() {
        assertEquals(4, characterReplacementMap("AABABBA", 1));
    }

    @Test
    void shouldReturnZeroOnEmptyStringMap() {
        assertEquals(0, characterReplacementMap("", 2));
    }

    @Test
    void shouldReturnOneOnSingleCharMap() {
        assertEquals(1, characterReplacementMap("A", 0));
    }

    @Test
    void shouldReturnLengthWhenAllSameMap() {
        assertEquals(5, characterReplacementMap("AAAAA", 0));
    }

    @Test
    void shouldReturnLongestRunWhenNoReplacementsAllowedMap() {
        assertEquals(3, characterReplacementMap("ABBBCC", 0));
    }

    @Test
    void shouldCoverWholeStringWhenKExceedsLengthMap() {
        assertEquals(4, characterReplacementMap("ABCD", 10));
    }

    @Test
    void shouldHandleAllDistinctWithOneReplacementMap() {
        assertEquals(2, characterReplacementMap("ABCDE", 1));
    }

    @Test
    void shouldHandleReplacementsInMiddleMap() {
        assertEquals(5, characterReplacementMap("AABBBAA", 2));
    }

    @Test
    void shouldHandleLongerMixedStringMap() {
        assertEquals(4, characterReplacementMap("ABAABBBA", 1));
    }
}
