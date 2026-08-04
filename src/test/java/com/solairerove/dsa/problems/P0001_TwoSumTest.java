package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0001_TwoSumTest {

    @Test
    void returnsIndicesFromMiddleOfArray() {
        int[] nums = {2, 7, 11, 15};

        int[] result = P0001_TwoSum.twoSum(nums, 9);

        assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    void returnsIndicesWithRepeatedValue() {
        int[] nums = {3, 2, 4};

        int[] result = P0001_TwoSum.twoSum(nums, 6);

        assertArrayEquals(new int[]{1, 2}, result);
    }

    @Test
    void returnsIndicesForDuplicateNumbers() {
        int[] nums = {3, 3};

        int[] result = P0001_TwoSum.twoSum(nums, 6);

        assertArrayEquals(new int[]{0, 1}, result);
    }
}
