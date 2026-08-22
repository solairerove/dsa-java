package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.solairerove.dsa.problems.P0026_RemoveDuplicatesFromSortedArray.removeDuplicates;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0026_RemoveDuplicatesFromSortedArrayTest {

    @Test
    void shouldHandleExampleOne() {
        int[] nums = {1, 1, 2};
        int k = removeDuplicates(nums);
        assertEquals(2, k);
        assertArrayEquals(new int[]{1, 2}, Arrays.copyOf(nums, k));
    }

    @Test
    void shouldHandleExampleTwo() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k = removeDuplicates(nums);
        assertEquals(5, k);
        assertArrayEquals(new int[]{0, 1, 2, 3, 4}, Arrays.copyOf(nums, k));
    }

    @Test
    void shouldHandleSingleElement() {
        int[] nums = {7};
        int k = removeDuplicates(nums);
        assertEquals(1, k);
        assertArrayEquals(new int[]{7}, Arrays.copyOf(nums, k));
    }

    @Test
    void shouldHandleAllDistinct() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = removeDuplicates(nums);
        assertEquals(5, k);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, Arrays.copyOf(nums, k));
    }

    @Test
    void shouldHandleAllIdentical() {
        int[] nums = {3, 3, 3, 3};
        int k = removeDuplicates(nums);
        assertEquals(1, k);
        assertArrayEquals(new int[]{3}, Arrays.copyOf(nums, k));
    }

    @Test
    void shouldHandleTwoIdentical() {
        int[] nums = {5, 5};
        int k = removeDuplicates(nums);
        assertEquals(1, k);
        assertArrayEquals(new int[]{5}, Arrays.copyOf(nums, k));
    }

    @Test
    void shouldHandleTwoDistinct() {
        int[] nums = {5, 6};
        int k = removeDuplicates(nums);
        assertEquals(2, k);
        assertArrayEquals(new int[]{5, 6}, Arrays.copyOf(nums, k));
    }

    @Test
    void shouldHandleNegativeNumbers() {
        int[] nums = {-3, -3, -1, 0, 0, 2};
        int k = removeDuplicates(nums);
        assertEquals(4, k);
        assertArrayEquals(new int[]{-3, -1, 0, 2}, Arrays.copyOf(nums, k));
    }

    @Test
    void shouldHandleDuplicatesOnlyAtEnd() {
        int[] nums = {1, 2, 3, 3, 3};
        int k = removeDuplicates(nums);
        assertEquals(3, k);
        assertArrayEquals(new int[]{1, 2, 3}, Arrays.copyOf(nums, k));
    }

    @Test
    void shouldHandleDuplicatesOnlyAtStart() {
        int[] nums = {1, 1, 1, 2, 3};
        int k = removeDuplicates(nums);
        assertEquals(3, k);
        assertArrayEquals(new int[]{1, 2, 3}, Arrays.copyOf(nums, k));
    }

    @Test
    void shouldHandleLongRunsOfDuplicates() {
        int[] nums = {1, 1, 1, 1, 2, 2, 2, 2, 3, 3};
        int k = removeDuplicates(nums);
        assertEquals(3, k);
        assertArrayEquals(new int[]{1, 2, 3}, Arrays.copyOf(nums, k));
    }
}
