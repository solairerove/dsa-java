package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("NewClassNamingConvention")
class P0242_ValidAnagramTest {

    @Test
    void returnsTrueForAnagram() {
        assertTrue(P0242_ValidAnagram.isAnagram("anagram", "nagaram"));
    }

    @Test
    void returnsFalseForNonAnagram() {
        assertFalse(P0242_ValidAnagram.isAnagram("rat", "car"));
    }

    @Test
    void returnsFalseWhenLengthsDiffer() {
        assertFalse(P0242_ValidAnagram.isAnagram("ab", "a"));
    }
}
