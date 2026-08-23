package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static com.solairerove.dsa.problems.P0167_TwoSumIIInputArrayIsSorted.twoSum;
import static com.solairerove.dsa.problems.P0167_TwoSumIIInputArrayIsSorted.twoSumBinarySearch;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0167_TwoSumIIInputArrayIsSortedTest {

    @Test
    void shouldSolveExampleOne() {
        assertArrayEquals(new int[]{1, 2}, twoSum(new int[]{2, 7, 11, 15}, 9));
    }

    @Test
    void shouldSolveExampleTwo() {
        assertArrayEquals(new int[]{1, 3}, twoSum(new int[]{2, 3, 4}, 6));
    }

    @Test
    void shouldSolveExampleThree() {
        assertArrayEquals(new int[]{1, 2}, twoSum(new int[]{-1, 0}, -1));
    }

    @Test
    void shouldUseFirstAndLastElements() {
        assertArrayEquals(new int[]{1, 4}, twoSum(new int[]{1, 2, 3, 9}, 10));
    }

    @Test
    void shouldUseAdjacentMiddleElements() {
        assertArrayEquals(new int[]{2, 3}, twoSum(new int[]{1, 4, 5, 100}, 9));
    }

    @Test
    void shouldHandleDuplicateValues() {
        assertArrayEquals(new int[]{1, 2}, twoSum(new int[]{3, 3}, 6));
    }

    @Test
    void shouldHandleAllNegatives() {
        assertArrayEquals(new int[]{1, 4}, twoSum(new int[]{-8, -5, -3, -1}, -9));
    }

    @Test
    void shouldHandleZeroTarget() {
        assertArrayEquals(new int[]{2, 4}, twoSum(new int[]{-5, -2, 1, 2}, 0));
    }

    @Test
    void shouldHandleRepeatedElementsWithLaterMatch() {
        assertArrayEquals(new int[]{4, 5}, twoSum(new int[]{1, 1, 1, 2, 5}, 7));
    }

    @Test
    void shouldReturnEmptyWhenNoPairExists() {
        assertArrayEquals(new int[]{}, twoSum(new int[]{1, 2, 3}, 100));
    }

    @Test
    void shouldHandleLargerSortedArray() {
        assertArrayEquals(new int[]{3, 8}, twoSum(new int[]{1, 2, 4, 6, 8, 10, 12, 14}, 18));
    }
    @Test
    void shouldSolveExampleOneBinarySearch() {
        assertArrayEquals(new int[]{1, 2}, twoSumBinarySearch(new int[]{2, 7, 11, 15}, 9));
    }

    @Test
    void shouldSolveExampleTwoBinarySearch() {
        assertArrayEquals(new int[]{1, 3}, twoSumBinarySearch(new int[]{2, 3, 4}, 6));
    }

    @Test
    void shouldSolveExampleThreeBinarySearch() {
        assertArrayEquals(new int[]{1, 2}, twoSumBinarySearch(new int[]{-1, 0}, -1));
    }

    @Test
    void shouldUseFirstAndLastElementsBinarySearch() {
        assertArrayEquals(new int[]{1, 4}, twoSumBinarySearch(new int[]{1, 2, 3, 9}, 10));
    }

    @Test
    void shouldUseAdjacentMiddleElementsBinarySearch() {
        assertArrayEquals(new int[]{2, 3}, twoSumBinarySearch(new int[]{1, 4, 5, 100}, 9));
    }

    @Test
    void shouldHandleDuplicateValuesBinarySearch() {
        assertArrayEquals(new int[]{1, 2}, twoSumBinarySearch(new int[]{3, 3}, 6));
    }

    @Test
    void shouldHandleAllNegativesBinarySearch() {
        assertArrayEquals(new int[]{1, 4}, twoSumBinarySearch(new int[]{-8, -5, -3, -1}, -9));
    }

    @Test
    void shouldHandleZeroTargetBinarySearch() {
        assertArrayEquals(new int[]{2, 4}, twoSumBinarySearch(new int[]{-5, -2, 1, 2}, 0));
    }

    @Test
    void shouldHandleRepeatedElementsWithLaterMatchBinarySearch() {
        assertArrayEquals(new int[]{4, 5}, twoSumBinarySearch(new int[]{1, 1, 1, 2, 5}, 7));
    }

    @Test
    void shouldReturnEmptyWhenNoPairExistsBinarySearch() {
        assertArrayEquals(new int[]{}, twoSumBinarySearch(new int[]{1, 2, 3}, 100));
    }

    @Test
    void shouldHandleLargerSortedArrayBinarySearch() {
        assertArrayEquals(new int[]{3, 8}, twoSumBinarySearch(new int[]{1, 2, 4, 6, 8, 10, 12, 14}, 18));
    }
}
