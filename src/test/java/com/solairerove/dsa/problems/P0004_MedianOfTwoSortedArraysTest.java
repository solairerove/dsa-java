package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static com.solairerove.dsa.problems.P0004_MedianOfTwoSortedArrays.findMedianSortedArrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0004_MedianOfTwoSortedArraysTest {

    @Test
    void shouldFindMedianExampleOne() {
        assertEquals(2.0, findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }

    @Test
    void shouldFindMedianExampleTwo() {
        assertEquals(2.5, findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    @Test
    void shouldHandleEmptyFirstArray() {
        assertEquals(1.0, findMedianSortedArrays(new int[]{}, new int[]{1}));
    }

    @Test
    void shouldHandleEmptySecondArray() {
        assertEquals(2.5, findMedianSortedArrays(new int[]{1, 2, 3, 4}, new int[]{}));
    }

    @Test
    void shouldHandleFirstArrayLonger() {
        assertEquals(3.0, findMedianSortedArrays(new int[]{1, 2, 3, 4}, new int[]{5}));
    }

    @Test
    void shouldHandleFirstArrayEntirelyLarger() {
        assertEquals(3.5, findMedianSortedArrays(new int[]{4, 5, 6}, new int[]{1, 2, 3}));
    }

    @Test
    void shouldHandleInterleavedValues() {
        assertEquals(4.5, findMedianSortedArrays(new int[]{1, 3, 5, 7}, new int[]{2, 4, 6, 8}));
    }

    @Test
    void shouldHandleDuplicates() {
        assertEquals(1.0, findMedianSortedArrays(new int[]{1, 1}, new int[]{1, 1, 1}));
    }

    @Test
    void shouldHandleNegativeNumbers() {
        assertEquals(-2.5, findMedianSortedArrays(new int[]{-5, -3}, new int[]{-2, -1}));
    }

    @Test
    void shouldHandleSingleElementEach() {
        assertEquals(1.5, findMedianSortedArrays(new int[]{1}, new int[]{2}));
    }

    @Test
    void shouldHandleUnevenLengthsOddTotal() {
        assertEquals(4.0, findMedianSortedArrays(new int[]{3}, new int[]{1, 2, 4, 5, 6, 7}));
    }
}
