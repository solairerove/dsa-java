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
}
