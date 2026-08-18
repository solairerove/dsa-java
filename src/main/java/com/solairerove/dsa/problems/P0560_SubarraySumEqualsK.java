package com.solairerove.dsa.problems;

import java.util.HashMap;
import java.util.Map;

public class P0560_SubarraySumEqualsK {

    // time O(n), space O(n)
    public static int subarraySum(int[] nums, int k) {
        int res = 0, currSum = 0;
        Map<Integer, Integer> ps = new HashMap<>();
        ps.put(0, 1);

        for (int num : nums) {
            currSum += num;
            int guess = currSum - k;
            res += ps.getOrDefault(guess, 0);
            ps.put(currSum, ps.getOrDefault(currSum, 0) + 1);
        }

        return res;
    }

    // time O(n^2), space O(1)
    public static int subarraySumNaive(int[] nums, int k) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == 0) {
                    if (nums[j] == k) res++;
                } else if (nums[j] - nums[i - 1] == k) res++;
            }
        }

        return res;
    }
}
