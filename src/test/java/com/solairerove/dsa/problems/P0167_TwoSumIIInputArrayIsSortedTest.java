package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static com.solairerove.dsa.problems.P0167_TwoSumIIInputArrayIsSorted.twoSumNaive;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0167_TwoSumIIInputArrayIsSortedTest {

    @Test
    void shouldSolveExampleOneNaive() {
        assertArrayEquals(new int[]{1, 2}, twoSumNaive(new int[]{2, 7, 11, 15}, 9));
    }

    @Test
    void shouldSolveExampleTwoNaive() {
        assertArrayEquals(new int[]{1, 3}, twoSumNaive(new int[]{2, 3, 4}, 6));
    }

    @Test
    void shouldSolveExampleThreeNaive() {
        assertArrayEquals(new int[]{1, 2}, twoSumNaive(new int[]{-1, 0}, -1));
    }

    @Test
    void shouldUseFirstAndLastElementsNaive() {
        assertArrayEquals(new int[]{1, 4}, twoSumNaive(new int[]{1, 2, 3, 9}, 10));
    }

    @Test
    void shouldUseAdjacentMiddleElementsNaive() {
        assertArrayEquals(new int[]{2, 3}, twoSumNaive(new int[]{1, 4, 5, 100}, 9));
    }

    @Test
    void shouldHandleDuplicateValuesNaive() {
        assertArrayEquals(new int[]{1, 2}, twoSumNaive(new int[]{3, 3}, 6));
    }

    @Test
    void shouldHandleAllNegativesNaive() {
        assertArrayEquals(new int[]{1, 4}, twoSumNaive(new int[]{-8, -5, -3, -1}, -9));
    }

    @Test
    void shouldHandleZeroTargetNaive() {
        assertArrayEquals(new int[]{2, 4}, twoSumNaive(new int[]{-5, -2, 1, 2}, 0));
    }

    @Test
    void shouldHandleRepeatedElementsWithLaterMatchNaive() {
        assertArrayEquals(new int[]{4, 5}, twoSumNaive(new int[]{1, 1, 1, 2, 5}, 7));
    }

    @Test
    void shouldReturnEmptyWhenNoPairExistsNaive() {
        assertArrayEquals(new int[]{}, twoSumNaive(new int[]{1, 2, 3}, 100));
    }

    @Test
    void shouldHandleLargerSortedArrayNaive() {
        assertArrayEquals(new int[]{3, 8}, twoSumNaive(new int[]{1, 2, 4, 6, 8, 10, 12, 14}, 18));
    }
}
