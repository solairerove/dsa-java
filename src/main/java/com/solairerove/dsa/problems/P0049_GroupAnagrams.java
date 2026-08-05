package com.solairerove.dsa.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P0049_GroupAnagrams {

    // time O(n * k), space O(n * k)
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> freq = new HashMap<>();
        for (String s : strs) {
            int[] cnt = new int[26];
            for (int j = 0; j < s.length(); j++) {
                cnt[s.charAt(j) - 'a']++;
            }
            freq.computeIfAbsent(Arrays.toString(cnt), v -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(freq.values());
    }
}
