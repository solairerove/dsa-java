package com.solairerove.dsa.problems;

import java.util.HashMap;
import java.util.Map;

public class P0076_MinimumWindowSubstring {

    // time O(n + m), space O(n + m)
    public static String minWindow(String s, String t) {
        Map<Character, Integer> freq = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char ch : t.toCharArray()) freq.merge(ch, 1, Integer::sum);

        int cnt = 0;
        int l = 0, r = 0;
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;
        while (r < s.length()) {
            char ch = s.charAt(r);
            window.merge(ch, 1, Integer::sum);

            if (freq.containsKey(ch) && freq.get(ch).equals(window.get(ch))) cnt++;

            while (cnt == freq.size()) {
                if ((r - l + 1) < resLen) {
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }

                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);
                if (freq.containsKey(leftChar) && window.get(leftChar) < freq.get(leftChar)) {
                    cnt--;
                }

                l++;
            }

            r++;
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
