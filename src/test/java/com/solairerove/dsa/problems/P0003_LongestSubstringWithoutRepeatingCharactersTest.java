package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0003_LongestSubstringWithoutRepeatingCharactersTest {

    @Test
    void returnsThreeForAbcabcbb() {
        assertEquals(3, P0003_LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    void returnsOneForRepeatedSingleChar() {
        assertEquals(1, P0003_LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("bbbbb"));
    }

    @Test
    void returnsThreeForPwwkew() {
        assertEquals(3, P0003_LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    void returnsZeroOnEmptyString() {
        assertEquals(0, P0003_LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(""));
    }

    @Test
    void returnsOneOnSingleChar() {
        assertEquals(1, P0003_LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("a"));
    }

    @Test
    void returnsFullLengthWhenAllDistinct() {
        assertEquals(5, P0003_LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcde"));
    }

    @Test
    void handlesSpacesAndDigits() {
        assertEquals(3, P0003_LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("a 1a 1"));
    }

    @Test
    void handlesDuplicateFarBehindWindow() {
        assertEquals(2, P0003_LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abba"));
    }

    @Test
    void handlesSymbols() {
        assertEquals(4, P0003_LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("!@#$!"));
    }

    @Test
    void handlesMixedCase() {
        assertEquals(4, P0003_LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("aAbBa"));
    }

    @Test
    void returnsThreeForAbcabcbbCount() {
        assertEquals(3, P0003_LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringCount("abcabcbb"));
    }

    @Test
    void returnsOneForRepeatedSingleCharCount() {
        assertEquals(1, P0003_LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringCount("bbbbb"));
    }

    @Test
    void returnsThreeForPwwkewCount() {
        assertEquals(3, P0003_LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringCount("pwwkew"));
    }

    @Test
    void returnsZeroOnEmptyStringCount() {
        assertEquals(0, P0003_LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringCount(""));
    }

    @Test
    void returnsOneOnSingleCharCount() {
        assertEquals(1, P0003_LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringCount("a"));
    }

    @Test
    void returnsFullLengthWhenAllDistinctCount() {
        assertEquals(5, P0003_LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringCount("abcde"));
    }

    @Test
    void handlesSpacesAndDigitsCount() {
        assertEquals(3, P0003_LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringCount("a 1a 1"));
    }

    @Test
    void handlesDuplicateFarBehindWindowCount() {
        assertEquals(2, P0003_LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringCount("abba"));
    }

    @Test
    void handlesSymbolsCount() {
        assertEquals(4, P0003_LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringCount("!@#$!"));
    }

    @Test
    void handlesMixedCaseCount() {
        assertEquals(4, P0003_LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringCount("aAbBa"));
    }
}
