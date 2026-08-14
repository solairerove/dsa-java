package com.solairerove.dsa.problems;

import java.util.HashMap;
import java.util.Map;

public class P0128_LongestConsecutiveSequence {

    // time O(n), space O(n)
    public static int longestConsecutive(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (hm.containsKey(num)) continue;

            hm.put(num, hm.getOrDefault(num - 1, 0) + hm.getOrDefault(num + 1, 0) + 1);
            hm.put(num - hm.getOrDefault(num - 1, 0), hm.get(num));
            hm.put(num + hm.getOrDefault(num + 1, 0), hm.get(num));

            res = Integer.max(res, hm.get(num));
        }

        return res;
    }
}
