package com.solairerove.dsa.problems;

public class P0159_LongestSubstringWithAtMostTwoDistinctCharacters {

    // time O(n), space O(1)
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] cnt = new int[128];
        int n = s.length(), l = 0, distinct = 0;
        for (int r = 0; r < n; r++) {
            if (cnt[s.charAt(r)]++ == 0) distinct++;

            if (distinct > 2) {
                if (--cnt[s.charAt(l++)] == 0) distinct--;
            }
        }

        return n - l;
    }
}
