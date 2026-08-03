package com.solairerove.dsa.problems;

import java.util.HashSet;
import java.util.Set;

public class P0217_ContainsDuplicate {

    // time O(n), space O(n)
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }

        return false;
    }
}
