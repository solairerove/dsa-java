package com.solairerove.dsa.problems;

import java.util.HashMap;
import java.util.Map;

public class P0159_LongestSubstringWithAtMostTwoDistinctCharacters {

    // time O(n), space O(1)
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        Map<Character, Integer> cnt = new HashMap<>();
        int l = 0;
        for (int r = 0; r < n; r++) {
            cnt.merge(s.charAt(r), 1, Integer::sum);

            if (cnt.size() > 2) {
                char left = s.charAt(l++);
                cnt.merge(left, -1, (a, b) -> a == 1 ? null : a + b);
            }
        }

        return n - l;
    }
}
