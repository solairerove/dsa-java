package com.solairerove.dsa.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P0018_4Sum {

    // time O(n^3), space O(1) excluding output
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if ((long) nums[i] * 4 > target) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int l = j + 1, r = n - 1;
                while (l < r) {
                    long guess = (long) nums[i] + nums[j] + nums[l] + nums[r];
                    if (guess == target) {
                        res.add(List.of(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;
                        while (l < r && nums[l] == nums[l - 1]) l++;
                        while (r > l && nums[r] == nums[r + 1]) r--;
                    } else if (guess < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }

        return res;
    }
}
