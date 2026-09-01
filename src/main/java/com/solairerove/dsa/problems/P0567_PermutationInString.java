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

    // time O(n), space O(1)
    public static boolean checkInclusionRequired(String s1, String s2) {
        int[] cnt = new int[26];
        for (char ch : s1.toCharArray()) {
            cnt[ch - 'a']++;
        }

        int required = s1.length();
        int l = 0, r = 0;
        while (r < s2.length()) {
            int right = s2.charAt(r) - 'a';
            if (cnt[right] > 0) required--;
            cnt[right]--;

            if (r - l + 1 > s1.length()) {
                int left = s2.charAt(l) - 'a';
                cnt[left]++;
                if (cnt[left] > 0) required++;

                l++;
            }

            if (required == 0) {
                return true;
            }

            r++;
        }

        return false;
    }
}
