package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0014_LongestCommonPrefixTest {

    @Test
    void returnsCommonPrefix() {
        String[] strs = {"flower", "flow", "flight"};

        assertEquals("fl", P0014_LongestCommonPrefix.longestCommonPrefix(strs));
    }

    @Test
    void returnsEmptyWhenNoCommonPrefix() {
        String[] strs = {"dog", "racecar", "car"};

        assertEquals("", P0014_LongestCommonPrefix.longestCommonPrefix(strs));
    }

    @Test
    void returnsWholeStringWhenSingleElement() {
        String[] strs = {"alone"};

        assertEquals("alone", P0014_LongestCommonPrefix.longestCommonPrefix(strs));
    }
}
