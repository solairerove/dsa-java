package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static com.solairerove.dsa.problems.P0041_FirstMissingPositive.firstMissingPositive;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0041_FirstMissingPositiveTest {

    @Test
    void shouldReturnThreeForExampleOne() {
        assertEquals(3, firstMissingPositive(new int[]{1, 2, 0}));
    }

    @Test
    void shouldReturnTwoForExampleTwo() {
        assertEquals(2, firstMissingPositive(new int[]{3, 4, -1, 1}));
    }

    @Test
    void shouldReturnOneForExampleThree() {
        assertEquals(1, firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    }

    @Test
    void shouldHandleSingleElementOne() {
        assertEquals(2, firstMissingPositive(new int[]{1}));
    }

    @Test
    void shouldHandleSingleElementNonOne() {
        assertEquals(1, firstMissingPositive(new int[]{2}));
    }

    @Test
    void shouldHandleAllNegatives() {
        assertEquals(1, firstMissingPositive(new int[]{-1, -2, -3}));
    }

    @Test
    void shouldHandleAllZeros() {
        assertEquals(1, firstMissingPositive(new int[]{0, 0, 0}));
    }

    @Test
    void shouldHandleContiguousRange() {
        assertEquals(6, firstMissingPositive(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    void shouldHandleDuplicates() {
        assertEquals(2, firstMissingPositive(new int[]{1, 1, 1, 1}));
    }

    @Test
    void shouldHandleUnsortedWithGap() {
        assertEquals(4, firstMissingPositive(new int[]{5, 3, 2, 1}));
    }

    @Test
    void shouldHandleMixOfLargeAndSmall() {
        assertEquals(2, firstMissingPositive(new int[]{1, 1000, -5, 3}));
    }

    @Test
    void shouldHandleEmptyArray() {
        assertEquals(1, firstMissingPositive(new int[]{}));
    }
}
