package com.solairerove.dsa.problems;

import java.util.HashMap;
import java.util.Map;

public class P0001_TwoSum {

    // time O(n), space O(n)
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = HashMap.newHashMap(n);
        for (int i = 0; i < n; i++) {
            int guess = target - nums[i];
            int j = map.getOrDefault(guess, -1);
            if (j >= 0) {
                return new int[] {j, i};
            }
            map.put(nums[i], i);
        }

        return new int[] {-1, -1};
    }
}
