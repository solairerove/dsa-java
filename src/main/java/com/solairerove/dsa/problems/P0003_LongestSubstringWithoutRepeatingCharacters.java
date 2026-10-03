package com.solairerove.dsa.problems;

public class P0003_LongestSubstringWithoutRepeatingCharacters {

    // time O(n), space O(1)
    public static int lengthOfLongestSubstring(String s) {
        int[] cnt = new int[128];
        int l = 0, res = 0;
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            l = Math.max(l, cnt[ch]);
            cnt[ch] = r + 1;

            res = Math.max(res, r - l + 1);
        }

        return res;
    }

    // time O(n), space O(1)
    public static int lengthOfLongestSubstringCount(String s) {
        int[] cnt = new int[128];
        int l = 0, r = 0;
        int res = 0;
        while (r < s.length()) {
            cnt[s.charAt(r)]++;
            while (cnt[s.charAt(r)] > 1) {
                cnt[s.charAt(l++)]--;
            }
            res = Math.max(res, r - l + 1);

            r++;
        }

        return res;
    }
}
