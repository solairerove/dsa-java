package com.solairerove.dsa.problems;

import java.util.HashSet;
import java.util.Set;

public class P1456_MaximumNumberOfVowelsInASubstringOfGivenLength {

    // time O(n), space O(1)
    public static int maxVowels(String s, int k) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        int l = 0, r = 0;
        int res = 0;
        int windowCounter = 0;
        while (r < s.length()) {
            char right = s.charAt(r);
            if (vowels.contains(right)) windowCounter++;

            if (r - l + 1 > k) {
                char left = s.charAt(l++);
                if (vowels.contains(left)) windowCounter--;
            }

            res = Math.max(res, windowCounter);
            r++;
        }

        return res;
    }

    // time O(n), space O(1)
    public static int maxVowelsFixedWindow(String s, int k) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int res = 0, cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) cnt++;
            if (i >= k && vowels.contains(s.charAt(i - k))) cnt--;

            res = Math.max(res, cnt);
        }

        return res;
    }

    // time O(n), space O(1)
    public static int maxVowelsLookupTable(String s, int k) {
        int[] vowels = new int[128];
        vowels['a']++;
        vowels['e']++;
        vowels['i']++;
        vowels['o']++;
        vowels['u']++;

        char[] chars = s.toCharArray();
        int max = 0;
        for (int i = 0; i < k; i++) {
            if (vowels[chars[i]] == 1) {
                max++;
            }
        }
        int temp = max;

        for (int i = k; i < chars.length; i++) {
            temp += vowels[chars[i]];
            temp -= vowels[chars[i - k]];

            if (max < temp) {
                max = temp;
            }
        }

        return max;
    }
}
