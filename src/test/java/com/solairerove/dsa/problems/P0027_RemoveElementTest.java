package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0027_RemoveElementTest {

    @Test
    void removesSingleOccurrence() {
        int[] nums = {3, 2, 2, 3};

        int k = P0027_RemoveElement.removeElement(nums, 3);

        assertEquals(2, k);
        assertArrayEquals(new int[]{2, 2}, Arrays.copyOf(nums, k));
    }

    @Test
    void removesMultipleOccurrences() {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};

        int k = P0027_RemoveElement.removeElement(nums, 2);

        assertEquals(5, k);
        int[] remaining = Arrays.copyOf(nums, k);
        Arrays.sort(remaining);
        assertArrayEquals(new int[]{0, 0, 1, 3, 4}, remaining);
    }

    @Test
    void returnsZeroWhenAllMatch() {
        int[] nums = {5, 5, 5};

        int k = P0027_RemoveElement.removeElement(nums, 5);

        assertEquals(0, k);
    }

    @Test
    void returnsZeroOnEmptyArray() {
        int[] nums = {};

        int k = P0027_RemoveElement.removeElement(nums, 1);

        assertEquals(0, k);
    }

    @Test
    void keepsEverythingWhenValAbsent() {
        int[] nums = {1, 2, 3, 4};

        int k = P0027_RemoveElement.removeElement(nums, 9);

        assertEquals(4, k);
        assertArrayEquals(new int[]{1, 2, 3, 4}, nums);
    }
}
