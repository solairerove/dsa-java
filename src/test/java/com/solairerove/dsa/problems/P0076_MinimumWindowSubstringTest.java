package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static com.solairerove.dsa.problems.P0076_MinimumWindowSubstring.minWindow;
import static com.solairerove.dsa.problems.P0076_MinimumWindowSubstring.minWindowMap;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0076_MinimumWindowSubstringTest {

    @Test
    void shouldFindWindowInExample() {
        assertEquals("BANC", minWindow("ADOBECODEBANC", "ABC"));
    }

    @Test
    void shouldReturnWholeStringWhenEqual() {
        assertEquals("a", minWindow("a", "a"));
    }

    @Test
    void shouldReturnEmptyWhenTLongerThanS() {
        assertEquals("", minWindow("a", "aa"));
    }

    @Test
    void shouldHandleDuplicatesInT() {
        assertEquals("aa", minWindow("aa", "aa"));
    }

    @Test
    void shouldHandleExcessOfNeededChar() {
        assertEquals("ab", minWindow("aab", "ab"));
    }

    @Test
    void shouldPickLastShortestWindow() {
        assertEquals("ba", minWindow("bba", "ab"));
    }

    @Test
    void shouldReturnEmptyWhenCharMissing() {
        assertEquals("", minWindow("abc", "d"));
    }

    @Test
    void shouldReturnEmptyWhenSIsEmpty() {
        assertEquals("", minWindow("", "a"));
    }

    @Test
    void shouldBeCaseSensitive() {
        assertEquals("", minWindow("abc", "A"));
    }

    @Test
    void shouldHandleRepeatedRequirement() {
        assertEquals("abbc", minWindow("aabbcc", "abc"));
    }

    @Test
    void shouldHandleScatteredChars() {
        assertEquals("cwae", minWindow("cabwefgewcwaefgcf", "cae"));
    }

    @Test
    void shouldShrinkFromLeft() {
        assertEquals("abc", minWindow("aaabc", "abc"));
    }

    @Test
    void shouldHandleAllSameChars() {
        assertEquals("aaa", minWindow("aaaaa", "aaa"));
    }

    @Test
    void shouldFindWindowInExampleMap() {
        assertEquals("BANC", minWindowMap("ADOBECODEBANC", "ABC"));
    }

    @Test
    void shouldReturnWholeStringWhenEqualMap() {
        assertEquals("a", minWindowMap("a", "a"));
    }

    @Test
    void shouldReturnEmptyWhenTLongerThanSMap() {
        assertEquals("", minWindowMap("a", "aa"));
    }

    @Test
    void shouldHandleDuplicatesInTMap() {
        assertEquals("aa", minWindowMap("aa", "aa"));
    }

    @Test
    void shouldHandleExcessOfNeededCharMap() {
        assertEquals("ab", minWindowMap("aab", "ab"));
    }

    @Test
    void shouldPickLastShortestWindowMap() {
        assertEquals("ba", minWindowMap("bba", "ab"));
    }

    @Test
    void shouldReturnEmptyWhenCharMissingMap() {
        assertEquals("", minWindowMap("abc", "d"));
    }

    @Test
    void shouldReturnEmptyWhenSIsEmptyMap() {
        assertEquals("", minWindowMap("", "a"));
    }

    @Test
    void shouldBeCaseSensitiveMap() {
        assertEquals("", minWindowMap("abc", "A"));
    }

    @Test
    void shouldHandleRepeatedRequirementMap() {
        assertEquals("abbc", minWindowMap("aabbcc", "abc"));
    }

    @Test
    void shouldHandleScatteredCharsMap() {
        assertEquals("cwae", minWindowMap("cabwefgewcwaefgcf", "cae"));
    }

    @Test
    void shouldShrinkFromLeftMap() {
        assertEquals("abc", minWindowMap("aaabc", "abc"));
    }

    @Test
    void shouldHandleAllSameCharsMap() {
        assertEquals("aaa", minWindowMap("aaaaa", "aaa"));
    }
}
