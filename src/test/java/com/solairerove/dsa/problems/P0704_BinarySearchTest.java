package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static com.solairerove.dsa.problems.P0704_BinarySearch.search;
import static com.solairerove.dsa.problems.P0704_BinarySearch.searchLowerBound;
import static com.solairerove.dsa.problems.P0704_BinarySearch.searchUpperBound;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0704_BinarySearchTest {

    @Test
    void leetcodeExampleOne() {
        assertEquals(4, search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }

    @Test
    void leetcodeExampleTwo() {
        assertEquals(-1, search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    }

    @Test
    void emptyInput() {
        assertEquals(-1, search(new int[]{}, 1));
    }

    @Test
    void singleElementFound() {
        assertEquals(0, search(new int[]{5}, 5));
    }

    @Test
    void singleElementMissing() {
        assertEquals(-1, search(new int[]{5}, 3));
    }

    @Test
    void findsFirstElement() {
        assertEquals(0, search(new int[]{1, 2, 3, 4, 5}, 1));
    }

    @Test
    void findsLastElement() {
        assertEquals(4, search(new int[]{1, 2, 3, 4, 5}, 5));
    }

    @Test
    void targetBelowRange() {
        assertEquals(-1, search(new int[]{1, 2, 3, 4, 5}, 0));
    }

    @Test
    void targetAboveRange() {
        assertEquals(-1, search(new int[]{1, 2, 3, 4, 5}, 6));
    }

    @Test
    void evenLengthArray() {
        assertEquals(2, search(new int[]{2, 4, 6, 8}, 6));
    }

    @Test
    void negativeValues() {
        assertEquals(1, search(new int[]{-10, -5, -1}, -5));
    }

    @Test
    void extremeBoundsNoOverflow() {
        assertEquals(1, search(new int[]{Integer.MIN_VALUE, 0, Integer.MAX_VALUE}, 0));
        assertEquals(2, search(new int[]{Integer.MIN_VALUE, 0, Integer.MAX_VALUE}, Integer.MAX_VALUE));
    }

    @Test
    void largeArrayEveryIndexFound() {
        int[] nums = new int[10_000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i * 2;
        }

        for (int i = 0; i < nums.length; i++) {
            assertEquals(i, search(nums, nums[i]));
        }
    }

    @Test
    void matchesArraysBinarySearchOnRandomInputs() {
        Random random = new Random(42);
        for (int t = 0; t < 500; t++) {
            int[] nums = random.ints(random.nextInt(20), -30, 30).distinct().sorted().toArray();
            int target = random.nextInt(-35, 35);

            int expected = Arrays.binarySearch(nums, target);
            assertEquals(expected < 0 ? -1 : expected, search(nums, target));
        }
    }

    @Test
    void upperBoundLeetcodeExampleOne() {
        assertEquals(4, searchUpperBound(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }

    @Test
    void upperBoundLeetcodeExampleTwo() {
        assertEquals(-1, searchUpperBound(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    }

    @Test
    void upperBoundEmptyInput() {
        assertEquals(-1, searchUpperBound(new int[]{}, 1));
    }

    @Test
    void upperBoundSingleElementFound() {
        assertEquals(0, searchUpperBound(new int[]{5}, 5));
    }

    @Test
    void upperBoundSingleElementMissing() {
        assertEquals(-1, searchUpperBound(new int[]{5}, 3));
    }

    @Test
    void upperBoundFindsFirstElement() {
        assertEquals(0, searchUpperBound(new int[]{1, 2, 3, 4, 5}, 1));
    }

    @Test
    void upperBoundFindsLastElement() {
        assertEquals(4, searchUpperBound(new int[]{1, 2, 3, 4, 5}, 5));
    }

    @Test
    void upperBoundTargetBelowRange() {
        assertEquals(-1, searchUpperBound(new int[]{1, 2, 3, 4, 5}, 0));
    }

    @Test
    void upperBoundTargetAboveRange() {
        assertEquals(-1, searchUpperBound(new int[]{1, 2, 3, 4, 5}, 6));
    }

    @Test
    void upperBoundEvenLengthArray() {
        assertEquals(2, searchUpperBound(new int[]{2, 4, 6, 8}, 6));
    }

    @Test
    void upperBoundNegativeValues() {
        assertEquals(1, searchUpperBound(new int[]{-10, -5, -1}, -5));
    }

    @Test
    void upperBoundExtremeBoundsNoOverflow() {
        assertEquals(1, searchUpperBound(new int[]{Integer.MIN_VALUE, 0, Integer.MAX_VALUE}, 0));
        assertEquals(2, searchUpperBound(new int[]{Integer.MIN_VALUE, 0, Integer.MAX_VALUE}, Integer.MAX_VALUE));
    }

    @Test
    void upperBoundLargeArrayEveryIndexFound() {
        int[] nums = new int[10_000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i * 2;
        }

        for (int i = 0; i < nums.length; i++) {
            assertEquals(i, searchUpperBound(nums, nums[i]));
        }
    }

    @Test
    void upperBoundMatchesArraysBinarySearchOnRandomInputs() {
        Random random = new Random(42);
        for (int t = 0; t < 500; t++) {
            int[] nums = random.ints(random.nextInt(20), -30, 30).distinct().sorted().toArray();
            int target = random.nextInt(-35, 35);

            int expected = Arrays.binarySearch(nums, target);
            assertEquals(expected < 0 ? -1 : expected, searchUpperBound(nums, target));
        }
    }

    @Test
    void lowerBoundLeetcodeExampleOne() {
        assertEquals(4, searchLowerBound(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }

    @Test
    void lowerBoundLeetcodeExampleTwo() {
        assertEquals(-1, searchLowerBound(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    }

    @Test
    void lowerBoundEmptyInput() {
        assertEquals(-1, searchLowerBound(new int[]{}, 1));
    }

    @Test
    void lowerBoundSingleElementFound() {
        assertEquals(0, searchLowerBound(new int[]{5}, 5));
    }

    @Test
    void lowerBoundSingleElementMissing() {
        assertEquals(-1, searchLowerBound(new int[]{5}, 3));
    }

    @Test
    void lowerBoundFindsFirstElement() {
        assertEquals(0, searchLowerBound(new int[]{1, 2, 3, 4, 5}, 1));
    }

    @Test
    void lowerBoundFindsLastElement() {
        assertEquals(4, searchLowerBound(new int[]{1, 2, 3, 4, 5}, 5));
    }

    @Test
    void lowerBoundTargetBelowRange() {
        assertEquals(-1, searchLowerBound(new int[]{1, 2, 3, 4, 5}, 0));
    }

    @Test
    void lowerBoundTargetAboveRange() {
        assertEquals(-1, searchLowerBound(new int[]{1, 2, 3, 4, 5}, 6));
    }

    @Test
    void lowerBoundEvenLengthArray() {
        assertEquals(2, searchLowerBound(new int[]{2, 4, 6, 8}, 6));
    }

    @Test
    void lowerBoundNegativeValues() {
        assertEquals(1, searchLowerBound(new int[]{-10, -5, -1}, -5));
    }

    @Test
    void lowerBoundExtremeBoundsNoOverflow() {
        assertEquals(1, searchLowerBound(new int[]{Integer.MIN_VALUE, 0, Integer.MAX_VALUE}, 0));
        assertEquals(2, searchLowerBound(new int[]{Integer.MIN_VALUE, 0, Integer.MAX_VALUE}, Integer.MAX_VALUE));
    }

    @Test
    void lowerBoundLargeArrayEveryIndexFound() {
        int[] nums = new int[10_000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i * 2;
        }

        for (int i = 0; i < nums.length; i++) {
            assertEquals(i, searchLowerBound(nums, nums[i]));
        }
    }

    @Test
    void lowerBoundMatchesArraysBinarySearchOnRandomInputs() {
        Random random = new Random(42);
        for (int t = 0; t < 500; t++) {
            int[] nums = random.ints(random.nextInt(20), -30, 30).distinct().sorted().toArray();
            int target = random.nextInt(-35, 35);

            int expected = Arrays.binarySearch(nums, target);
            assertEquals(expected < 0 ? -1 : expected, searchLowerBound(nums, target));
        }
    }
}
