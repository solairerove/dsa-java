package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static com.solairerove.dsa.problems.P0035_SearchInsertPosition.searchInsert;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0035_SearchInsertPositionTest {

    @Test
    void leetcodeExampleOne() {
        assertEquals(2, searchInsert(new int[]{1, 3, 5, 6}, 5));
    }

    @Test
    void leetcodeExampleTwo() {
        assertEquals(1, searchInsert(new int[]{1, 3, 5, 6}, 2));
    }

    @Test
    void leetcodeExampleThree() {
        assertEquals(4, searchInsert(new int[]{1, 3, 5, 6}, 7));
    }

    @Test
    void insertAtBeginning() {
        assertEquals(0, searchInsert(new int[]{1, 3, 5, 6}, 0));
    }

    @Test
    void emptyInput() {
        assertEquals(0, searchInsert(new int[]{}, 5));
    }

    @Test
    void singleElementFound() {
        assertEquals(0, searchInsert(new int[]{5}, 5));
    }

    @Test
    void singleElementInsertBefore() {
        assertEquals(0, searchInsert(new int[]{5}, 3));
    }

    @Test
    void singleElementInsertAfter() {
        assertEquals(1, searchInsert(new int[]{5}, 8));
    }

    @Test
    void findsFirstElement() {
        assertEquals(0, searchInsert(new int[]{1, 2, 3, 4, 5}, 1));
    }

    @Test
    void findsLastElement() {
        assertEquals(4, searchInsert(new int[]{1, 2, 3, 4, 5}, 5));
    }

    @Test
    void negativeValues() {
        assertEquals(1, searchInsert(new int[]{-10, -5, -1}, -7));
        assertEquals(1, searchInsert(new int[]{-10, -5, -1}, -5));
    }

    @Test
    void extremeBoundsNoOverflow() {
        assertEquals(0, searchInsert(new int[]{Integer.MIN_VALUE, 0, Integer.MAX_VALUE}, Integer.MIN_VALUE));
        assertEquals(2, searchInsert(new int[]{Integer.MIN_VALUE, 0, Integer.MAX_VALUE}, 1));
        assertEquals(2, searchInsert(new int[]{Integer.MIN_VALUE, 0, Integer.MAX_VALUE}, Integer.MAX_VALUE));
    }

    @Test
    void largeArrayEveryPositionFound() {
        int[] nums = new int[10_000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i * 2;
        }

        for (int i = 0; i < nums.length; i++) {
            assertEquals(i, searchInsert(nums, nums[i]));
            assertEquals(i + 1, searchInsert(nums, nums[i] + 1));
        }
    }

    @Test
    void matchesArraysBinarySearchOnRandomInputs() {
        Random random = new Random(42);
        for (int t = 0; t < 500; t++) {
            int[] nums = random.ints(random.nextInt(20), -30, 30).distinct().sorted().toArray();
            int target = random.nextInt(-35, 35);

            int expected = Arrays.binarySearch(nums, target);
            assertEquals(expected < 0 ? -(expected + 1) : expected, searchInsert(nums, target));
        }
    }
}
