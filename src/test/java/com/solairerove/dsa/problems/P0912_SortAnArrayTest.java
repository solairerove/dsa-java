package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@SuppressWarnings("NewClassNamingConvention")
class P0912_SortAnArrayTest {

    @Test
    void sortArray_example1() {
        assertArrayEquals(new int[]{1, 2, 3, 5}, P0912_SortAnArray.sortArray(new int[]{5, 2, 3, 1}));
    }

    @Test
    void sortArray_example2() {
        assertArrayEquals(new int[]{0, 0, 1, 1, 2, 5}, P0912_SortAnArray.sortArray(new int[]{5, 1, 1, 2, 0, 0}));
    }

    @Test
    void sortArray_singleElement() {
        assertArrayEquals(new int[]{42}, P0912_SortAnArray.sortArray(new int[]{42}));
    }

    @Test
    void sortArray_twoElementsUnsorted() {
        assertArrayEquals(new int[]{1, 2}, P0912_SortAnArray.sortArray(new int[]{2, 1}));
    }

    @Test
    void sortArray_alreadySorted() {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, P0912_SortAnArray.sortArray(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    void sortArray_reversed() {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, P0912_SortAnArray.sortArray(new int[]{6, 5, 4, 3, 2, 1}));
    }

    @Test
    void sortArray_allEqual() {
        assertArrayEquals(new int[]{7, 7, 7, 7}, P0912_SortAnArray.sortArray(new int[]{7, 7, 7, 7}));
    }

    @Test
    void sortArray_negativeNumbers() {
        assertArrayEquals(new int[]{-5, -3, -1, 0, 2}, P0912_SortAnArray.sortArray(new int[]{0, -1, 2, -3, -5}));
    }

    @Test
    void sortArray_oddLength() {
        assertArrayEquals(new int[]{1, 3, 4, 8, 9}, P0912_SortAnArray.sortArray(new int[]{9, 3, 1, 8, 4}));
    }

    @Test
    void sortArray_boundaryValues() {
        assertArrayEquals(new int[]{-50000, -1, 0, 1, 50000},
                P0912_SortAnArray.sortArray(new int[]{50000, -1, 0, 1, -50000}));
    }

    @Test
    void sortArray_largeRandomMatchesArraysSort() {
        Random random = new Random(912);
        int[] nums = new int[50_000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(100_001) - 50_000;
        }

        int[] expected = nums.clone();
        Arrays.sort(expected);

        assertArrayEquals(expected, P0912_SortAnArray.sortArray(nums));
    }

    @Test
    void sortArray_sortsInPlace() {
        int[] nums = {4, 2, 9, 1};
        int[] result = P0912_SortAnArray.sortArray(nums);
        assertSame(nums, result);
        assertArrayEquals(new int[]{1, 2, 4, 9}, nums);
    }

    @Test
    void sortArray_empty() {
        assertArrayEquals(new int[]{}, P0912_SortAnArray.sortArray(new int[]{}));
    }
}
