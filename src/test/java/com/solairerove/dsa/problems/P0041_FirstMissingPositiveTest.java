package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static com.solairerove.dsa.problems.P0041_FirstMissingPositive.firstMissingPositiveCycleSort;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0041_FirstMissingPositiveTest {

    @Test
    void shouldReturnThreeForExampleOneCycleSort() {
        assertEquals(3, firstMissingPositiveCycleSort(new int[]{1, 2, 0}));
    }

    @Test
    void shouldReturnTwoForExampleTwoCycleSort() {
        assertEquals(2, firstMissingPositiveCycleSort(new int[]{3, 4, -1, 1}));
    }

    @Test
    void shouldReturnOneForExampleThreeCycleSort() {
        assertEquals(1, firstMissingPositiveCycleSort(new int[]{7, 8, 9, 11, 12}));
    }

    @Test
    void shouldHandleSingleElementOneCycleSort() {
        assertEquals(2, firstMissingPositiveCycleSort(new int[]{1}));
    }

    @Test
    void shouldHandleSingleElementNonOneCycleSort() {
        assertEquals(1, firstMissingPositiveCycleSort(new int[]{2}));
    }

    @Test
    void shouldHandleAllNegativesCycleSort() {
        assertEquals(1, firstMissingPositiveCycleSort(new int[]{-1, -2, -3}));
    }

    @Test
    void shouldHandleAllZerosCycleSort() {
        assertEquals(1, firstMissingPositiveCycleSort(new int[]{0, 0, 0}));
    }

    @Test
    void shouldHandleContiguousRangeCycleSort() {
        assertEquals(6, firstMissingPositiveCycleSort(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    void shouldHandleDuplicatesCycleSort() {
        assertEquals(2, firstMissingPositiveCycleSort(new int[]{1, 1, 1, 1}));
    }

    @Test
    void shouldHandleUnsortedWithGapCycleSort() {
        assertEquals(4, firstMissingPositiveCycleSort(new int[]{5, 3, 2, 1}));
    }

    @Test
    void shouldHandleMixOfLargeAndSmallCycleSort() {
        assertEquals(2, firstMissingPositiveCycleSort(new int[]{1, 1000, -5, 3}));
    }

    @Test
    void shouldHandleEmptyArrayCycleSort() {
        assertEquals(1, firstMissingPositiveCycleSort(new int[]{}));
    }
}
