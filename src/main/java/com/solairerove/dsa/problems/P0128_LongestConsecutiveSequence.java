package com.solairerove.dsa.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P0128_LongestConsecutiveSequence {

    // time O(n), space O(n)
    public static int longestConsecutive(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (hm.containsKey(num)) continue;

            int left = hm.getOrDefault(num - 1, 0);
            int right = hm.getOrDefault(num + 1, 0);
            int len = left + right + 1;

            hm.put(num, len);
            hm.put(num - left, len);
            hm.put(num + right, len);

            res = Math.max(res, len);
        }

        return res;
    }

    // time O(n), space O(n)
    public static int longestConsecutiveSet(int[] nums) {
        Set<Integer> hs = new HashSet<>(nums.length * 4 / 3 + 1);
        for (int num : nums) hs.add(num);

        int res = 0;
        for (int e : hs) {
            if (hs.contains(e - 1)) continue;

            int length = 1;
            int curr = e;
            while (hs.contains(++curr)) length++;
            res = Math.max(res, length);
        }

        return res;
    }
}
