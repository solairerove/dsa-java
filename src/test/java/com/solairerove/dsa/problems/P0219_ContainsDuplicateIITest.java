package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("NewClassNamingConvention")
class P0219_ContainsDuplicateIITest {

    @Test
    void returnsTrueWhenAdjacentDuplicate() {
        int[] nums = {1, 2, 3, 1};

        assertTrue(P0219_ContainsDuplicateII.containsNearbyDuplicate(nums, 3));
    }

    @Test
    void returnsTrueWhenDuplicateNextToEachOther() {
        int[] nums = {1, 0, 1, 1};

        assertTrue(P0219_ContainsDuplicateII.containsNearbyDuplicate(nums, 1));
    }

    @Test
    void returnsFalseWhenDuplicateTooFar() {
        int[] nums = {1, 2, 3, 1, 2, 3};

        assertFalse(P0219_ContainsDuplicateII.containsNearbyDuplicate(nums, 2));
    }

    @Test
    void returnsFalseWhenAllDistinct() {
        int[] nums = {1, 2, 3, 4, 5};

        assertFalse(P0219_ContainsDuplicateII.containsNearbyDuplicate(nums, 10));
    }

    @Test
    void returnsFalseWhenKIsZero() {
        int[] nums = {1, 1, 1};

        assertFalse(P0219_ContainsDuplicateII.containsNearbyDuplicate(nums, 0));
    }

    @Test
    void returnsFalseOnSingleElement() {
        int[] nums = {7};

        assertFalse(P0219_ContainsDuplicateII.containsNearbyDuplicate(nums, 1));
    }

    @Test
    void returnsTrueWhenDuplicateExactlyKApart() {
        int[] nums = {1, 2, 3, 4, 1};

        assertTrue(P0219_ContainsDuplicateII.containsNearbyDuplicate(nums, 4));
    }

    @Test
    void returnsFalseWhenDuplicateOneBeyondK() {
        int[] nums = {1, 2, 3, 4, 1};

        assertFalse(P0219_ContainsDuplicateII.containsNearbyDuplicate(nums, 3));
    }

    @Test
    void handlesNegativeNumbers() {
        int[] nums = {-1, -2, -1};

        assertTrue(P0219_ContainsDuplicateII.containsNearbyDuplicate(nums, 2));
    }
}
