package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static com.solairerove.dsa.problems.P0033_SearchInRotatedSortedArray.search;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0033_SearchInRotatedSortedArrayTest {

    @Test
    void leetcodeExampleOne() {
        assertEquals(4, search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    @Test
    void leetcodeExampleTwo() {
        assertEquals(-1, search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }

    @Test
    void leetcodeExampleThree() {
        assertEquals(-1, search(new int[]{1}, 0));
    }

    @Test
    void singleElementFound() {
        assertEquals(0, search(new int[]{1}, 1));
    }

    @Test
    void twoElementsRotated() {
        assertEquals(1, search(new int[]{3, 1}, 1));
        assertEquals(0, search(new int[]{3, 1}, 3));
    }

    @Test
    void notRotatedFindsEveryElement() {
        int[] nums = {1, 3, 5, 7, 9, 11};
        for (int i = 0; i < nums.length; i++) {
            assertEquals(i, search(nums, nums[i]));
        }
    }

    @Test
    void targetIsPivotValue() {
        assertEquals(4, search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    @Test
    void targetIsFirstElement() {
        assertEquals(0, search(new int[]{4, 5, 6, 7, 0, 1, 2}, 4));
    }

    @Test
    void targetIsLastElement() {
        assertEquals(6, search(new int[]{4, 5, 6, 7, 0, 1, 2}, 2));
    }

    @Test
    void targetBelowMinimum() {
        assertEquals(-1, search(new int[]{4, 5, 6, 7, 0, 1, 2}, -5));
    }

    @Test
    void targetAboveMaximum() {
        assertEquals(-1, search(new int[]{4, 5, 6, 7, 0, 1, 2}, 100));
    }

    @Test
    void targetInsideGapBetweenParts() {
        assertEquals(-1, search(new int[]{5, 6, 7, 1, 2, 3}, 4));
    }

    @Test
    void negativeValues() {
        assertEquals(1, search(new int[]{2, -7, -3, 0}, -7));
    }

    @Test
    void everyRotationEveryTarget() {
        int[] sorted = {-4, -1, 0, 3, 8, 12, 17};
        int n = sorted.length;
        for (int k = 0; k < n; k++) {
            int[] rotated = new int[n];
            for (int i = 0; i < n; i++) {
                rotated[i] = sorted[(i + k) % n];
            }
            for (int i = 0; i < n; i++) {
                assertEquals(i, search(rotated, rotated[i]));
            }
            assertEquals(-1, search(rotated, 100));
            assertEquals(-1, search(rotated, 1));
        }
    }

    @Test
    void matchesLinearScanOnRandomInputs() {
        Random random = new Random(42);
        for (int t = 0; t < 500; t++) {
            int n = 1 + random.nextInt(20);
            int[] sorted = random.ints(-50, 50).distinct().limit(n).sorted().toArray();
            int k = random.nextInt(n);
            int[] rotated = new int[n];
            for (int i = 0; i < n; i++) {
                rotated[i] = sorted[(i + k) % n];
            }
            int target = random.nextInt(101) - 50;
            assertEquals(linearScan(rotated, target), search(rotated, target));
        }
    }

    private static int linearScan(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }

        return -1;
    }
}
