package com.solairerove.dsa.problems;

public class P0344_ReverseString {

    // time O(n), space O(1)
    public static void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l <= r) swap(s, l++, r--);
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
