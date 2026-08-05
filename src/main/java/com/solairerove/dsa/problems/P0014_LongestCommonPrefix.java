package com.solairerove.dsa.problems;

import java.util.Arrays;

public class P0014_LongestCommonPrefix {

    // time O(n log n), space O(1)
    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length - 1];
        int i = 0;
        while (i < first.length()) {
            if (first.charAt(i) == last.charAt(i)) {
                i++;
            } else {
                break;
            }
        }

        if (i == 0) {
            return "";
        }

        return first.substring(0, i);
    }
}
