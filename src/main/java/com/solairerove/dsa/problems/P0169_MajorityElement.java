package com.solairerove.dsa.problems;

import java.util.Arrays;

public class P0169_MajorityElement {

    // time O(n * log(n)), space O(1)
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);

        return nums[nums.length / 2];
    }
}
