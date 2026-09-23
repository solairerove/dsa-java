package com.solairerove.dsa.problems;

import java.util.HashMap;
import java.util.Map;

public class P0560_SubarraySumEqualsK {

    // time O(n), space O(n)
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>(nums.length);
        freq.put(0, 1);

        int res = 0, ps = 0;
        for (int num : nums) {
            ps += num;
            res += freq.getOrDefault(ps - k, 0);
            freq.merge(ps, 1, Integer::sum);
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
