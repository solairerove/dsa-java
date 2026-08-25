package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static com.solairerove.dsa.problems.P0189_RotateArray.rotate;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0189_RotateArrayTest {

    @Test
    void shouldRotateExampleOne() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, nums);
    }

    @Test
    void shouldRotateExampleTwo() {
        int[] nums = {-1, -100, 3, 99};
        rotate(nums, 2);
        assertArrayEquals(new int[]{3, 99, -1, -100}, nums);
    }

    @Test
    void shouldLeaveArrayUnchangedWhenKIsZero() {
        int[] nums = {1, 2, 3};
        rotate(nums, 0);
        assertArrayEquals(new int[]{1, 2, 3}, nums);
    }

    @Test
    void shouldLeaveArrayUnchangedWhenKEqualsLength() {
        int[] nums = {1, 2, 3, 4};
        rotate(nums, 4);
        assertArrayEquals(new int[]{1, 2, 3, 4}, nums);
    }

    @Test
    void shouldHandleKGreaterThanLength() {
        int[] nums = {1, 2, 3, 4, 5};
        rotate(nums, 7);
        assertArrayEquals(new int[]{4, 5, 1, 2, 3}, nums);
    }

    @Test
    void shouldHandleSingleElement() {
        int[] nums = {42};
        rotate(nums, 5);
        assertArrayEquals(new int[]{42}, nums);
    }

    @Test
    void shouldHandleTwoElements() {
        int[] nums = {1, 2};
        rotate(nums, 1);
        assertArrayEquals(new int[]{2, 1}, nums);
    }

    @Test
    void shouldRotateByOne() {
        int[] nums = {1, 2, 3, 4, 5};
        rotate(nums, 1);
        assertArrayEquals(new int[]{5, 1, 2, 3, 4}, nums);
    }

    @Test
    void shouldRotateByLengthMinusOne() {
        int[] nums = {1, 2, 3, 4, 5};
        rotate(nums, 4);
        assertArrayEquals(new int[]{2, 3, 4, 5, 1}, nums);
    }

    @Test
    void shouldHandleDuplicateValues() {
        int[] nums = {1, 1, 2, 2};
        rotate(nums, 2);
        assertArrayEquals(new int[]{2, 2, 1, 1}, nums);
    }

    @Test
    void shouldHandleKMultipleOfLength() {
        int[] nums = {1, 2, 3};
        rotate(nums, 9);
        assertArrayEquals(new int[]{1, 2, 3}, nums);
    }

    @Test
    void shouldComposeToFullRotation() {
        int[] nums = {1, 2, 3, 4, 5};
        rotate(nums, 2);
        rotate(nums, 3);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, nums);
    }
}
