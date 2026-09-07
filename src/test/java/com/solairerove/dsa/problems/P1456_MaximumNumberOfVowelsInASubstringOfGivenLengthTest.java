package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static com.solairerove.dsa.problems.P1456_MaximumNumberOfVowelsInASubstringOfGivenLength.maxVowels;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P1456_MaximumNumberOfVowelsInASubstringOfGivenLengthTest {

    @Test
    void leetcodeExampleOne() {
        assertEquals(3, maxVowels("abciiidef", 3));
    }

    @Test
    void leetcodeExampleTwo() {
        assertEquals(2, maxVowels("aeiou", 2));
    }

    @Test
    void leetcodeExampleThree() {
        assertEquals(2, maxVowels("leetcode", 3));
    }

    @Test
    void noVowels() {
        assertEquals(0, maxVowels("rhythm", 4));
    }

    @Test
    void allVowelsWindowIsWholeString() {
        assertEquals(5, maxVowels("aeiou", 5));
    }

    @Test
    void singleCharVowel() {
        assertEquals(1, maxVowels("a", 1));
    }

    @Test
    void singleCharConsonant() {
        assertEquals(0, maxVowels("b", 1));
    }

    @Test
    void windowOfOne() {
        assertEquals(1, maxVowels("bcadef", 1));
    }

    @Test
    void vowelsAtEnd() {
        assertEquals(3, maxVowels("bcdaei", 3));
    }

    @Test
    void vowelsAtStart() {
        assertEquals(3, maxVowels("aeibcd", 3));
    }

    @Test
    void bestWindowInMiddle() {
        assertEquals(2, maxVowels("xxaexx", 2));
    }

    @Test
    void kEqualsStringLengthNoVowels() {
        assertEquals(0, maxVowels("xyz", 3));
    }

    @Test
    void repeatedPattern() {
        assertEquals(2, maxVowels("abababab", 4));
    }

    @Test
    void longRunOfVowelsAfterConsonants() {
        assertEquals(4, maxVowels("bbbbaaaabbbb", 5));
    }
}
