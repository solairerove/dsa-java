package com.solairerove.dsa.problems;

import java.util.HashMap;
import java.util.Map;

public class P0076_MinimumWindowSubstring {

    // time O(n + m), space O(1)
    public static String minWindow(String s, String t) {
        int[] freq = new int[128];
        for (char ch : t.toCharArray()) freq[ch]++;

        int l = 0, r = 0;
        int required = t.length();
        int i = 0, length = Integer.MAX_VALUE;
        while (r < s.length()) {
            if (freq[s.charAt(r)] > 0) required--;
            freq[s.charAt(r)]--;

            while (required == 0) {
                if (r - l + 1 < length) {
                    length = r - l + 1;
                    i = l;
                }

                freq[s.charAt(l)]++;
                if (freq[s.charAt(l)] > 0) required++;

                l++;
            }
            r++;
        }

        return length == Integer.MAX_VALUE ? "" : s.substring(i, i + length);
    }

    // time O(n + m), space O(n + m)
    public static String minWindowMap(String s, String t) {
        Map<Character, Integer> freq = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char ch : t.toCharArray()) freq.merge(ch, 1, Integer::sum);

        int have = 0, need = freq.size();
        int l = 0, r = 0;
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;
        while (r < s.length()) {
            char ch = s.charAt(r);
            window.merge(ch, 1, Integer::sum);

            if (freq.containsKey(ch) && freq.get(ch).equals(window.get(ch))) have++;

            while (have == need) {
                if ((r - l + 1) < resLen) {
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }

                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);
                if (freq.containsKey(leftChar) && window.get(leftChar) < freq.get(leftChar)) {
                    have--;
                }

                l++;
            }

            r++;
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
