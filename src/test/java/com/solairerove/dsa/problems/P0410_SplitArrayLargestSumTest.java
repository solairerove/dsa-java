package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static com.solairerove.dsa.problems.P0410_SplitArrayLargestSum.splitArray;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0410_SplitArrayLargestSumTest {

    @Test
    void shouldSplitExampleOne() {
        assertEquals(18, splitArray(new int[]{7, 2, 5, 10, 8}, 2));
    }

    @Test
    void shouldSplitExampleTwo() {
        assertEquals(9, splitArray(new int[]{1, 2, 3, 4, 5}, 2));
    }

    @Test
    void shouldReturnSumWhenSingleSubarray() {
        assertEquals(15, splitArray(new int[]{1, 2, 3, 4, 5}, 1));
    }

    @Test
    void shouldReturnMaxWhenSplitPerElement() {
        assertEquals(5, splitArray(new int[]{1, 2, 3, 4, 5}, 5));
    }

    @Test
    void shouldHandleSingleElement() {
        assertEquals(7, splitArray(new int[]{7}, 1));
    }

    @Test
    void shouldHandleAllEqualElements() {
        assertEquals(4, splitArray(new int[]{2, 2, 2, 2}, 2));
    }

    @Test
    void shouldHandleZeros() {
        assertEquals(0, splitArray(new int[]{0, 0, 0}, 2));
    }

    @Test
    void shouldHandleDominantMaxElement() {
        assertEquals(100, splitArray(new int[]{1, 1, 100, 1, 1}, 3));
    }

    @Test
    void shouldHandleMoreSubarraysThanNeededSlots() {
        assertEquals(4, splitArray(new int[]{1, 4, 4}, 3));
    }

    @Test
    void shouldHandleDescendingValues() {
        assertEquals(25, splitArray(new int[]{10, 5, 13, 4, 8, 4, 5, 11, 14, 9, 16, 10, 20, 8}, 8));
    }
}
