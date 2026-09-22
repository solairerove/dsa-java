package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static com.solairerove.dsa.problems.P0081_SearchInRotatedSortedArrayII.search;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("NewClassNamingConvention")
class P0081_SearchInRotatedSortedArrayIITest {

    @Test
    void leetcodeExampleOne() {
        assertTrue(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
    }

    @Test
    void leetcodeExampleTwo() {
        assertFalse(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
    }

    @Test
    void singleElementFound() {
        assertTrue(search(new int[]{1}, 1));
    }

    @Test
    void singleElementNotFound() {
        assertFalse(search(new int[]{1}, 0));
    }

    @Test
    void twoElementsBothFound() {
        assertTrue(search(new int[]{1, 3}, 1));
        assertTrue(search(new int[]{1, 3}, 3));
    }

    @Test
    void twoElementsRotated() {
        assertTrue(search(new int[]{3, 1}, 1));
        assertTrue(search(new int[]{3, 1}, 3));
        assertFalse(search(new int[]{3, 1}, 2));
    }

    @Test
    void allDuplicatesTargetPresent() {
        assertTrue(search(new int[]{1, 1, 1, 1, 1, 1, 1}, 1));
    }

    @Test
    void allDuplicatesTargetAbsent() {
        assertFalse(search(new int[]{1, 1, 1, 1, 1, 1, 1}, 2));
    }

    @Test
    void duplicatesHideRotationPointLeft() {
        assertTrue(search(new int[]{1, 0, 1, 1, 1}, 0));
    }

    @Test
    void duplicatesHideRotationPointRight() {
        assertTrue(search(new int[]{1, 1, 1, 0, 1}, 0));
    }

    @Test
    void duplicatesHideRotationPointAbsent() {
        assertFalse(search(new int[]{1, 1, 1, 0, 1}, 2));
    }

    @Test
    void notRotatedFindsEveryElement() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        for (int num : nums) {
            assertTrue(search(nums, num));
        }
    }

    @Test
    void notRotatedMissingTargets() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        assertFalse(search(nums, 0));
        assertFalse(search(nums, 8));
    }

    @Test
    void rotatedFindsEveryElement() {
        int[] nums = {4, 5, 6, 6, 7, 0, 1, 2, 2};
        for (int num : nums) {
            assertTrue(search(nums, num));
        }
    }

    @Test
    void rotatedMissingTargets() {
        int[] nums = {4, 5, 6, 6, 7, 0, 1, 2, 2};
        assertFalse(search(nums, 3));
        assertFalse(search(nums, 8));
        assertFalse(search(nums, -1));
    }

    @Test
    void targetAtFirstPosition() {
        assertTrue(search(new int[]{5, 6, 6, 7, 1, 2, 3}, 5));
    }

    @Test
    void targetAtLastPosition() {
        assertTrue(search(new int[]{5, 6, 6, 7, 1, 2, 3}, 3));
    }

    @Test
    void negativeValues() {
        assertTrue(search(new int[]{0, 1, 2, -3, -2, -2, -1}, -3));
        assertFalse(search(new int[]{0, 1, 2, -3, -2, -2, -1}, -4));
    }

    @Test
    void boundaryValues() {
        assertTrue(search(new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0}, Integer.MIN_VALUE));
        assertTrue(search(new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0}, Integer.MAX_VALUE));
    }

    @Test
    void everyRotationOfArrayWithDuplicates() {
        int[] base = {0, 1, 1, 2, 3, 3, 4};
        for (int shift = 0; shift < base.length; shift++) {
            int[] rotated = new int[base.length];
            for (int i = 0; i < base.length; i++) {
                rotated[i] = base[(i + shift) % base.length];
            }

            for (int num : base) {
                assertTrue(search(rotated, num));
            }
            assertFalse(search(rotated, 5));
            assertFalse(search(rotated, -1));
        }
    }
}
