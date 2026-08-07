package com.solairerove.dsa.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P0347_TopKFrequentElements {

    // time O(n + k * d), space O(d), d = distinct values in nums
    public static int[] topKFrequentNaive(int[] nums, int k) {
        // naive approach
        // count frequency using haspmap
        // iterate this map k times each time finding max frequence
        // add in to res [], and continue to iterate again filtering freq by res
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            if (!freq.containsKey(num)) {
                freq.put(num, 0);
            }

            freq.put(num, freq.get(num) + 1);
        }

        Set<Integer> set = new HashSet<>();
        int[] res = new int[k];
        for (int j = 0; j < k; j++) {
            int maxV = 0;
            int maxK = nums[0];
            for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
                if (!set.contains(e.getKey()) && e.getValue() > maxV) {
                    maxV = e.getValue();
                    maxK = e.getKey();
                }
            }
            if (!set.contains(maxK)) {
                set.add(maxK);
                res[j] = maxK;
            }
        }

        return res;
    }
}
