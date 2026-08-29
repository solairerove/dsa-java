package com.solairerove.dsa.problems;

import java.util.HashMap;
import java.util.Map;

public class P0424_LongestRepeatingCharacterReplacement {

    // time O(n), space O(n)
    public static int characterReplacement(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        int l = 0, r = 0;
        int res = 0, maxFreq = 0;
        while (r < s.length()) {
            freq.merge(s.charAt(r), 1, Integer::sum);
            maxFreq = Math.max(maxFreq, freq.get(s.charAt(r)));

            while ((r - l + 1) - maxFreq > k) {
                freq.put(s.charAt(l), freq.get(s.charAt(l)) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }

        return res;
    }
}
