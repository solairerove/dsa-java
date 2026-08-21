package com.solairerove.dsa.problems;

public class P0125_ValidPalindrome {

    // time O(n), space O(1)
    public static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) l++;
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) r--;

            char left = Character.toLowerCase(s.charAt(l++));
            char right = Character.toLowerCase(s.charAt(r--));
            if (left != right) return false;
        }

        return true;
    }
}
