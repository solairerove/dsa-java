package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static com.solairerove.dsa.problems.P0088_MergeSortedArray.merge;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0088_MergeSortedArrayTest {

    @Test
    void shouldMergeExampleOne() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        merge(nums1, 3, new int[]{2, 5, 6}, 3);
        assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, nums1);
    }

    @Test
    void shouldHandleEmptySecondArray() {
        int[] nums1 = {1};
        merge(nums1, 1, new int[]{}, 0);
        assertArrayEquals(new int[]{1}, nums1);
    }

    @Test
    void shouldHandleEmptyFirstArray() {
        int[] nums1 = {0};
        merge(nums1, 0, new int[]{1}, 1);
        assertArrayEquals(new int[]{1}, nums1);
    }

    @Test
    void shouldHandleBothEmpty() {
        int[] nums1 = {};
        merge(nums1, 0, new int[]{}, 0);
        assertArrayEquals(new int[]{}, nums1);
    }

    @Test
    void shouldHandleSecondArrayEntirelySmaller() {
        int[] nums1 = {4, 5, 6, 0, 0, 0};
        merge(nums1, 3, new int[]{1, 2, 3}, 3);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, nums1);
    }

    @Test
    void shouldHandleSecondArrayEntirelyLarger() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        merge(nums1, 3, new int[]{7, 8, 9}, 3);
        assertArrayEquals(new int[]{1, 2, 3, 7, 8, 9}, nums1);
    }

    @Test
    void shouldHandleAllDuplicates() {
        int[] nums1 = {2, 2, 0, 0};
        merge(nums1, 2, new int[]{2, 2}, 2);
        assertArrayEquals(new int[]{2, 2, 2, 2}, nums1);
    }

    @Test
    void shouldHandleNegativeNumbers() {
        int[] nums1 = {-5, -1, 0, 0, 0};
        merge(nums1, 2, new int[]{-10, -3, 4}, 3);
        assertArrayEquals(new int[]{-10, -5, -3, -1, 4}, nums1);
    }

    @Test
    void shouldHandleInterleavedValues() {
        int[] nums1 = {1, 3, 5, 0, 0, 0};
        merge(nums1, 3, new int[]{2, 4, 6}, 3);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, nums1);
    }

    @Test
    void shouldHandleLongerFirstArray() {
        int[] nums1 = {1, 2, 4, 5, 6, 0};
        merge(nums1, 5, new int[]{3}, 1);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, nums1);
    }

    @Test
    void shouldHandleLongerSecondArray() {
        int[] nums1 = {3, 0, 0, 0, 0};
        merge(nums1, 1, new int[]{1, 2, 4, 5}, 4);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, nums1);
    }

    @Test
    void shouldHandleSingleElementEach() {
        int[] nums1 = {2, 0};
        merge(nums1, 1, new int[]{1}, 1);
        assertArrayEquals(new int[]{1, 2}, nums1);
    }
}
