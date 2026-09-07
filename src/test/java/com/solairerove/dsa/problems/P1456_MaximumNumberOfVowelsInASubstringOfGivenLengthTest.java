package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static com.solairerove.dsa.problems.P1456_MaximumNumberOfVowelsInASubstringOfGivenLength.maxVowels;
import static com.solairerove.dsa.problems.P1456_MaximumNumberOfVowelsInASubstringOfGivenLength.maxVowelsFixedWindow;
import static com.solairerove.dsa.problems.P1456_MaximumNumberOfVowelsInASubstringOfGivenLength.maxVowelsLookupTable;
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
    @Test
    void fixedWindowLeetcodeExampleOne() {
        assertEquals(3, maxVowelsFixedWindow("abciiidef", 3));
    }

    @Test
    void fixedWindowLeetcodeExampleTwo() {
        assertEquals(2, maxVowelsFixedWindow("aeiou", 2));
    }

    @Test
    void fixedWindowLeetcodeExampleThree() {
        assertEquals(2, maxVowelsFixedWindow("leetcode", 3));
    }

    @Test
    void fixedWindowNoVowels() {
        assertEquals(0, maxVowelsFixedWindow("rhythm", 4));
    }

    @Test
    void fixedWindowAllVowelsWindowIsWholeString() {
        assertEquals(5, maxVowelsFixedWindow("aeiou", 5));
    }

    @Test
    void fixedWindowSingleCharVowel() {
        assertEquals(1, maxVowelsFixedWindow("a", 1));
    }

    @Test
    void fixedWindowSingleCharConsonant() {
        assertEquals(0, maxVowelsFixedWindow("b", 1));
    }

    @Test
    void fixedWindowWindowOfOne() {
        assertEquals(1, maxVowelsFixedWindow("bcadef", 1));
    }

    @Test
    void fixedWindowVowelsAtEnd() {
        assertEquals(3, maxVowelsFixedWindow("bcdaei", 3));
    }

    @Test
    void fixedWindowVowelsAtStart() {
        assertEquals(3, maxVowelsFixedWindow("aeibcd", 3));
    }

    @Test
    void fixedWindowBestWindowInMiddle() {
        assertEquals(2, maxVowelsFixedWindow("xxaexx", 2));
    }

    @Test
    void fixedWindowKEqualsStringLengthNoVowels() {
        assertEquals(0, maxVowelsFixedWindow("xyz", 3));
    }

    @Test
    void fixedWindowRepeatedPattern() {
        assertEquals(2, maxVowelsFixedWindow("abababab", 4));
    }

    @Test
    void fixedWindowLongRunOfVowelsAfterConsonants() {
        assertEquals(4, maxVowelsFixedWindow("bbbbaaaabbbb", 5));
    }
    @Test
    void lookupTableLeetcodeExampleOne() {
        assertEquals(3, maxVowelsLookupTable("abciiidef", 3));
    }

    @Test
    void lookupTableLeetcodeExampleTwo() {
        assertEquals(2, maxVowelsLookupTable("aeiou", 2));
    }

    @Test
    void lookupTableLeetcodeExampleThree() {
        assertEquals(2, maxVowelsLookupTable("leetcode", 3));
    }

    @Test
    void lookupTableNoVowels() {
        assertEquals(0, maxVowelsLookupTable("rhythm", 4));
    }

    @Test
    void lookupTableAllVowelsWindowIsWholeString() {
        assertEquals(5, maxVowelsLookupTable("aeiou", 5));
    }

    @Test
    void lookupTableSingleCharVowel() {
        assertEquals(1, maxVowelsLookupTable("a", 1));
    }

    @Test
    void lookupTableSingleCharConsonant() {
        assertEquals(0, maxVowelsLookupTable("b", 1));
    }

    @Test
    void lookupTableWindowOfOne() {
        assertEquals(1, maxVowelsLookupTable("bcadef", 1));
    }

    @Test
    void lookupTableVowelsAtEnd() {
        assertEquals(3, maxVowelsLookupTable("bcdaei", 3));
    }

    @Test
    void lookupTableVowelsAtStart() {
        assertEquals(3, maxVowelsLookupTable("aeibcd", 3));
    }

    @Test
    void lookupTableBestWindowInMiddle() {
        assertEquals(2, maxVowelsLookupTable("xxaexx", 2));
    }

    @Test
    void lookupTableKEqualsStringLengthNoVowels() {
        assertEquals(0, maxVowelsLookupTable("xyz", 3));
    }

    @Test
    void lookupTableRepeatedPattern() {
        assertEquals(2, maxVowelsLookupTable("abababab", 4));
    }

    @Test
    void lookupTableLongRunOfVowelsAfterConsonants() {
        assertEquals(4, maxVowelsLookupTable("bbbbaaaabbbb", 5));
    }
}
