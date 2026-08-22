package com.solairerove.dsa.problems;

public class P1768_MergeStringsAlternately {

    // time O(n + m), space O(n + m)
    public static String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int l = 0, r = 0;
        while (l < word1.length() && r < word2.length()) {
            sb.append(word1.charAt(l++));
            sb.append(word2.charAt(r++));
        }

        sb.append(word1.substring(l));
        sb.append(word2.substring(r));

        return sb.toString();
    }
}
