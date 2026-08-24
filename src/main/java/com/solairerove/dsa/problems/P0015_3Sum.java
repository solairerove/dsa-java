package com.solairerove.dsa.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P0015_3Sum {

    // time O(n^2), space O(1) excluding output
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1, r = n - 1;
            while (l < r) {
                int guess = nums[i] + nums[l] + nums[r];
                if (guess == 0) {
                    res.add(List.of(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) l++;
                } else if (guess < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return res;
    }

    // time O(n^2), space O(n)
    public static List<List<Integer>> threeSumNaive(int[] nums) {
        Arrays.sort(nums);
        // nums = [-1,0,1,2,-1,-4] -> [-4,-1,-1,0,1,2]
        Set<List<Integer>> res = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1, k = n - 1;
            while (j < n && k > i + 1 && j < k) {
                int guess = nums[i] + nums[j] + nums[k];
                if (guess == 0) {
                    res.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                } else if (guess < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return new ArrayList<>(res);
    }
}
