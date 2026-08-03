package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("NewClassNamingConvention")
class P0217_ContainsDuplicateTest {

    @Test
    void returnsTrueWhenDuplicateExists() {
        int[] nums = {1, 2, 3, 1};

        assertTrue(P0217_ContainsDuplicate.containsDuplicate(nums));
    }

    @Test
    void returnsFalseWhenAllDistinct() {
        int[] nums = {1, 2, 3, 4};

        assertFalse(P0217_ContainsDuplicate.containsDuplicate(nums));
    }

    @Test
    void returnsTrueWithMultipleDuplicates() {
        int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};

        assertTrue(P0217_ContainsDuplicate.containsDuplicate(nums));
    }
}
