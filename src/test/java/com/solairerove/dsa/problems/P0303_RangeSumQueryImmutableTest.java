package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0303_RangeSumQueryImmutableTest {

    @Test
    void sumRange_example1() {
        P0303_RangeSumQueryImmutable obj = new P0303_RangeSumQueryImmutable(new int[]{-2, 0, 3, -5, 2, -1});
        assertEquals(1, obj.sumRange(0, 2));
        assertEquals(-1, obj.sumRange(2, 5));
        assertEquals(-3, obj.sumRange(0, 5));
    }

    @Test
    void sumRange_singleElementRange() {
        P0303_RangeSumQueryImmutable obj = new P0303_RangeSumQueryImmutable(new int[]{1, 2, 3, 4});
        assertEquals(1, obj.sumRange(0, 0));
        assertEquals(3, obj.sumRange(2, 2));
        assertEquals(4, obj.sumRange(3, 3));
    }

    @Test
    void sumRange_singleElementArray() {
        P0303_RangeSumQueryImmutable obj = new P0303_RangeSumQueryImmutable(new int[]{7});
        assertEquals(7, obj.sumRange(0, 0));
    }

    @Test
    void sumRange_wholeArray() {
        P0303_RangeSumQueryImmutable obj = new P0303_RangeSumQueryImmutable(new int[]{1, 2, 3, 4, 5});
        assertEquals(15, obj.sumRange(0, 4));
    }

    @Test
    void sumRange_allNegative() {
        P0303_RangeSumQueryImmutable obj = new P0303_RangeSumQueryImmutable(new int[]{-1, -2, -3, -4});
        assertEquals(-9, obj.sumRange(1, 3));
    }

    @Test
    void sumRange_zeros() {
        P0303_RangeSumQueryImmutable obj = new P0303_RangeSumQueryImmutable(new int[]{0, 0, 0});
        assertEquals(0, obj.sumRange(0, 2));
    }

    @Test
    void sumRange_repeatedQueriesAreStable() {
        P0303_RangeSumQueryImmutable obj = new P0303_RangeSumQueryImmutable(new int[]{5, -3, 8, 1});
        assertEquals(11, obj.sumRange(0, 3));
        assertEquals(11, obj.sumRange(0, 3));
        assertEquals(6, obj.sumRange(1, 3));
    }

    @Test
    void sumRange_boundaryValues() {
        P0303_RangeSumQueryImmutable obj = new P0303_RangeSumQueryImmutable(new int[]{-100000, 100000, -100000});
        assertEquals(0, obj.sumRange(0, 1));
        assertEquals(-100000, obj.sumRange(0, 2));
    }

    @Test
    void sumRange_matchesBruteForceOnRandomInput() {
        Random random = new Random(303);
        int[] nums = new int[500];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(20001) - 10000;
        }

        int[] original = nums.clone();
        P0303_RangeSumQueryImmutable obj = new P0303_RangeSumQueryImmutable(nums);
        for (int q = 0; q < 200; q++) {
            int left = random.nextInt(original.length);
            int right = left + random.nextInt(original.length - left);

            int expected = 0;
            for (int i = left; i <= right; i++) {
                expected += original[i];
            }

            assertEquals(expected, obj.sumRange(left, right));
        }
    }
}
