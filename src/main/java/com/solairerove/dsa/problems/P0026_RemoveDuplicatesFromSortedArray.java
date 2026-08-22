package com.solairerove.dsa.problems;

public class P0026_RemoveDuplicatesFromSortedArray {

    // time O(n), space O(1)
    public static int removeDuplicates(int[] nums) {
        int i = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[j - 1]) {
                nums[i++] = nums[j];
            }
        }

        return i;
    }
}
