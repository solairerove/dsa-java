package com.solairerove.dsa.problems;

public class P0303_RangeSumQueryImmutable {

    private final int[] preSum;

    public P0303_RangeSumQueryImmutable(int[] nums) {
        preSum = nums;
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] += preSum[i - 1];
        }
    }

    // time O(1), space O(n)
    public int sumRange(int left, int right) {
        if (left == 0) {
            return preSum[right];
        }

        return preSum[right] - preSum[left - 1];
    }
}
