package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static com.solairerove.dsa.problems.P1768_MergeStringsAlternately.mergeAlternately;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P1768_MergeStringsAlternatelyTest {

    @Test
    void shouldMergeEqualLengthExampleOne() {
        assertEquals("apbqcr", mergeAlternately("abc", "pqr"));
    }

    @Test
    void shouldAppendTailOfSecondWordExampleTwo() {
        assertEquals("apbqrs", mergeAlternately("ab", "pqrs"));
    }

    @Test
    void shouldAppendTailOfFirstWordExampleThree() {
        assertEquals("apbqcd", mergeAlternately("abcd", "pq"));
    }

    @Test
    void shouldHandleSingleCharacterEach() {
        assertEquals("ab", mergeAlternately("a", "b"));
    }

    @Test
    void shouldHandleEmptyFirstWord() {
        assertEquals("pqr", mergeAlternately("", "pqr"));
    }

    @Test
    void shouldHandleEmptySecondWord() {
        assertEquals("abc", mergeAlternately("abc", ""));
    }

    @Test
    void shouldHandleBothEmpty() {
        assertEquals("", mergeAlternately("", ""));
    }

    @Test
    void shouldHandleFirstWordOneCharLonger() {
        assertEquals("apbqc", mergeAlternately("abc", "pq"));
    }

    @Test
    void shouldHandleSecondWordMuchLonger() {
        assertEquals("apqrstu", mergeAlternately("a", "pqrstu"));
    }

    @Test
    void shouldHandleRepeatedCharacters() {
        assertEquals("ababab", mergeAlternately("aaa", "bbb"));
    }

    @Test
    void shouldHandleDigits() {
        assertEquals("142536", mergeAlternately("123", "456"));
    }
}
