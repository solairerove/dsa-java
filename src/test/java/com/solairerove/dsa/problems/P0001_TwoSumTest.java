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

    @Test
    void returnsIndicesWithNegativeNumbers() {
        int[] nums = {-3, 4, 3, 90};

        int[] result = P0001_TwoSum.twoSum(nums, 0);

        assertArrayEquals(new int[]{0, 2}, result);
    }

    @Test
    void returnsFirstCompletedPair() {
        int[] nums = {1, 5, 8, 2, 9};

        int[] result = P0001_TwoSum.twoSum(nums, 10);

        assertArrayEquals(new int[]{2, 3}, result);
    }

    @Test
    void returnsIndicesWithZeroTarget() {
        int[] nums = {0, 4, 3, 0};

        int[] result = P0001_TwoSum.twoSum(nums, 0);

        assertArrayEquals(new int[]{0, 3}, result);
    }

    @Test
    void returnsMinusOnesWhenNoPair() {
        int[] nums = {1, 2, 3};

        int[] result = P0001_TwoSum.twoSum(nums, 100);

        assertArrayEquals(new int[]{-1, -1}, result);
    }
}
