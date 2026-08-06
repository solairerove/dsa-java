package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0075_SortColorsTest {

    @Test
    void sortsLeetCodeExample() {
        int[] nums = {2, 0, 2, 1, 1, 0};

        P0075_SortColors.sortColors(nums);

        assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2}, nums);
    }

    @Test
    void sortsTwoElements() {
        int[] nums = {2, 0, 1};

        P0075_SortColors.sortColors(nums);

        assertArrayEquals(new int[]{0, 1, 2}, nums);
    }

    @Test
    void handlesSingleElement() {
        int[] nums = {1};

        P0075_SortColors.sortColors(nums);

        assertArrayEquals(new int[]{1}, nums);
    }

    @Test
    void handlesEmptyArray() {
        int[] nums = {};

        P0075_SortColors.sortColors(nums);

        assertArrayEquals(new int[]{}, nums);
    }

    @Test
    void handlesAlreadySorted() {
        int[] nums = {0, 0, 1, 1, 2, 2};

        P0075_SortColors.sortColors(nums);

        assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2}, nums);
    }

    @Test
    void handlesReverseSorted() {
        int[] nums = {2, 2, 1, 1, 0, 0};

        P0075_SortColors.sortColors(nums);

        assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2}, nums);
    }

    @Test
    void handlesSingleColorOnly() {
        int[] zeros = {0, 0, 0};
        int[] ones = {1, 1, 1};
        int[] twos = {2, 2, 2};

        P0075_SortColors.sortColors(zeros);
        P0075_SortColors.sortColors(ones);
        P0075_SortColors.sortColors(twos);

        assertArrayEquals(new int[]{0, 0, 0}, zeros);
        assertArrayEquals(new int[]{1, 1, 1}, ones);
        assertArrayEquals(new int[]{2, 2, 2}, twos);
    }

    @Test
    void handlesMissingMiddleColor() {
        int[] nums = {2, 0, 2, 0, 2};

        P0075_SortColors.sortColors(nums);

        assertArrayEquals(new int[]{0, 0, 2, 2, 2}, nums);
    }
}
