package com.solairerove.dsa.problems;

public class P1929_ConcatenationOfArray {

    // time O(n), space O(n)
    public static int[] getConcatenationNaive(int[] nums) {
        int n = nums.length;
        int size = n * 2;
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = nums[i % n];
        }

        return ans;
    }

    // time O(n), space O(n)
    public static int[] getConcatenationDualWrite(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];
        for (int i = 0; i < n; i++) {
            ans[i] = ans[i + n] = nums[i];
        }

        return ans;
    }
}
