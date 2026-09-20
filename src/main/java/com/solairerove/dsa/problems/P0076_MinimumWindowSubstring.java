package com.solairerove.dsa.problems;

public class P0076_MinimumWindowSubstring {

    // time O(n + m), space O(1)
    public static String minWindow(String s, String t) {
        int[] cnt = new int[128];
        for (char c : t.toCharArray()) {
            cnt[c]++;
        }
        int required = t.length();

        int l = 0;
        int start = 0, bestLen = Integer.MAX_VALUE;
        for (int r = 0; r < s.length(); r++) {
            int cr = s.charAt(r);
            if (cnt[cr] > 0) required--;
            cnt[cr]--;

            while (required == 0) {
                if (r - l + 1 < bestLen) {
                    bestLen = r - l + 1;
                    start = l;
                }

                int cl = s.charAt(l);
                if (cnt[cl] == 0) required++;
                cnt[cl]++;

                l++;
            }
        }

        return bestLen == Integer.MAX_VALUE ? "" : s.substring(start, start + bestLen);
    }
}
