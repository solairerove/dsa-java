package com.solairerove.dsa.problems;

import java.util.Arrays;

public class P0567_PermutationInString {

    // time O(n * 26), space O(1)
    public static boolean checkInclusion(String s1, String s2) {
        int[] cnt = new int[26];
        for (char c : s1.toCharArray()) cnt[c - 'a']++;

        int l = 0, r = 0;
        int[] windowFreq = new int[26];
        while (r < s2.length()) {
            windowFreq[s2.charAt(r++) - 'a']++;
            if (r - l > s1.length()) windowFreq[s2.charAt(l++) - 'a']--;
            if (Arrays.equals(cnt, windowFreq)) return true;
        }

        return false;
    }
}
