package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0852_PeakIndexInAMountainArrayTest {

    @Test
    void minimalMountain() {
        int[] arr = {0, 1, 0};

        assertEquals(1, P0852_PeakIndexInAMountainArray.peakIndexInMountainArray(arr));
    }

    @Test
    void peakInMiddle() {
        int[] arr = {0, 2, 1, 0};

        assertEquals(1, P0852_PeakIndexInAMountainArray.peakIndexInMountainArray(arr));
    }

    @Test
    void peakShiftedRight() {
        int[] arr = {0, 10, 5, 2};

        assertEquals(1, P0852_PeakIndexInAMountainArray.peakIndexInMountainArray(arr));
    }

    @Test
    void peakNextToEnd() {
        int[] arr = {1, 2, 3, 4, 5, 6, 0};

        assertEquals(5, P0852_PeakIndexInAMountainArray.peakIndexInMountainArray(arr));
    }

    @Test
    void peakNextToStart() {
        int[] arr = {1, 9, 8, 7, 6, 5, 4};

        assertEquals(1, P0852_PeakIndexInAMountainArray.peakIndexInMountainArray(arr));
    }

    @Test
    void longSymmetricMountain() {
        int[] arr = {0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0};

        assertEquals(5, P0852_PeakIndexInAMountainArray.peakIndexInMountainArray(arr));
    }

    @Test
    void largeValues() {
        int[] arr = {0, 1_000_000, 999_999};

        assertEquals(1, P0852_PeakIndexInAMountainArray.peakIndexInMountainArray(arr));
    }
}
