package com.solairerove.dsa.problems;

import java.util.HashSet;
import java.util.Set;

public class P0219_ContainsDuplicateII {

    // time O(n), space O(min(n, k))
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int l = 0, r = 0;
        while (r < nums.length) {
            if (!set.add(nums[r++])) return true;
            if (r - l == k + 1) set.remove(nums[l++]);
        }

        return false;
    }
}
