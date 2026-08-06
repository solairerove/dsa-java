package com.solairerove.dsa.problems;

import java.util.Arrays;

public class P0169_MajorityElement {

    // time O(n * log(n)), space O(1)
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);

        return nums[nums.length / 2];
    }

    // time O(n), space O(1)
    public static int majorityElementBoyerMoore(int[] nums) {
        int res = 0, cnt = 0;
        for (int num : nums) {
            if (cnt == 0) {
                res = num;
            }
            cnt += (num == res) ? 1 : -1;
        }

        return res;
    }
}
