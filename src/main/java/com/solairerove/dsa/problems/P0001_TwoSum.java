package com.solairerove.dsa.problems;

import java.util.HashMap;
import java.util.Map;

public class P0001_TwoSum {

    // time O(n), space O(n)
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            var guess = target - nums[i];
            if (map.containsKey(guess)) {
                return new int[] {map.get(guess), i};
            }
            map.put(nums[i], i);
        }

        return new int[] {};
    }
}
