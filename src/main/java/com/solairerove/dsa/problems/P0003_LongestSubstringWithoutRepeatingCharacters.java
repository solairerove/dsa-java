package com.solairerove.dsa.problems;

public class P0003_LongestSubstringWithoutRepeatingCharacters {

    // time O(n), space O(1)
    public static int lengthOfLongestSubstring(String s) {
        int[] chars = new int[128];
        int l = 0, r = 0;
        int res = 0;
        while (r < s.length()) {
            char ch = s.charAt(r);
            l = Math.max(l, chars[ch]);
            chars[ch] = r + 1;

            res = Math.max(res, r - l + 1);
            r++;
        }

        return res;
    }
}
