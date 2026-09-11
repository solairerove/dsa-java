package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static com.solairerove.dsa.problems.P0159_LongestSubstringWithAtMostTwoDistinctCharacters.lengthOfLongestSubstringTwoDistinct;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0159_LongestSubstringWithAtMostTwoDistinctCharactersTest {

    @Test
    void leetcodeExampleOne() {
        assertEquals(3, lengthOfLongestSubstringTwoDistinct("eceba"));
    }

    @Test
    void leetcodeExampleTwo() {
        assertEquals(5, lengthOfLongestSubstringTwoDistinct("ccaabbb"));
    }

    @Test
    void emptyString() {
        assertEquals(0, lengthOfLongestSubstringTwoDistinct(""));
    }

    @Test
    void singleCharacter() {
        assertEquals(1, lengthOfLongestSubstringTwoDistinct("a"));
    }

    @Test
    void twoSameCharacters() {
        assertEquals(2, lengthOfLongestSubstringTwoDistinct("aa"));
    }

    @Test
    void twoDistinctCharacters() {
        assertEquals(2, lengthOfLongestSubstringTwoDistinct("ab"));
    }

    @Test
    void allSameCharacter() {
        assertEquals(5, lengthOfLongestSubstringTwoDistinct("bbbbb"));
    }

    @Test
    void exactlyThreeDistinct() {
        assertEquals(2, lengthOfLongestSubstringTwoDistinct("abc"));
    }

    @Test
    void alternatingTwoCharacters() {
        assertEquals(6, lengthOfLongestSubstringTwoDistinct("ababab"));
    }

    @Test
    void allDistinctCharacters() {
        assertEquals(2, lengthOfLongestSubstringTwoDistinct("abcdef"));
    }

    @Test
    void bestWindowAtStart() {
        assertEquals(4, lengthOfLongestSubstringTwoDistinct("ababc"));
    }

    @Test
    void bestWindowAtEnd() {
        assertEquals(4, lengthOfLongestSubstringTwoDistinct("cabab"));
    }

    @Test
    void bestWindowInMiddle() {
        assertEquals(6, lengthOfLongestSubstringTwoDistinct("abbbbac"));
    }

    @Test
    void uppercaseAndLowercaseAreDistinct() {
        assertEquals(2, lengthOfLongestSubstringTwoDistinct("aAbB"));
    }

    @Test
    void digitsAndSymbols() {
        assertEquals(4, lengthOfLongestSubstringTwoDistinct("11##2"));
    }

    @Test
    void longRunThenSwitch() {
        assertEquals(7, lengthOfLongestSubstringTwoDistinct("aaaabbbc"));
    }

    @Test
    void tailIsLongest() {
        assertEquals(5, lengthOfLongestSubstringTwoDistinct("abcccdd"));
    }
}
