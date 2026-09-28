package com.solairerove.dsa.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P0049_GroupAnagrams {

    // time O(n * k), space O(n * k)
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] cnt = new char[26];
            for (int i = 0; i < s.length(); i++) {
                cnt[s.charAt(i) - 'a']++;
            }
            map.computeIfAbsent(new String(cnt), k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
