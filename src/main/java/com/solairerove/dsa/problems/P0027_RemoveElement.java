package com.solairerove.dsa.problems;

public class P0027_RemoveElement {

    // time O(n), space O(1)
    public static int removeElement(int[] nums, int val) {
        int i = 0, j = nums.length;
        while (i < j) {
            if (nums[i] == val) {
                nums[i] = nums[--j];
            } else {
                i++;
            }
        }

        return i;
    }
}
