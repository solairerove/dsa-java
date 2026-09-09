package com.solairerove.dsa.problems;

import java.util.HashMap;
import java.util.Map;

public class P0904_FruitIntoBaskets {

    // time O(n), space O(1)
    public static int totalFruit(int[] fruits) {
        int n = fruits.length;
        Map<Integer, Integer> cnt = new HashMap<>();
        int l = 0, r = 0;
        while (r < n) {
            int fruit = fruits[r];
            cnt.merge(fruit, 1, Integer::sum);

            if (cnt.size() > 2) {
                int left = fruits[l];
                cnt.put(left, cnt.get(left) - 1);
                if (cnt.get(left) == 0) {
                    cnt.remove(left);
                }
                l++;
            }
            r++;
        }

        return n - l;
    }

    // time O(n), space O(1)
    public static int totalFruitTwoPointer(int[] fruits) {
        int n = fruits.length;
        if (n <= 2) {
            return n;
        }

        int lb = fruits[0];
        int rb = fruits[1];

        int l = 0;
        int r = 1;
        int max = 0;

        while (r < n) {
            if (fruits[r] != lb && fruits[r] != rb) {
                max = Math.max(max, r - l);

                int temp = r - 1;
                while (temp >= l && fruits[temp] == fruits[r - 1]) {
                    temp--;
                }
                l = temp + 1;

                lb = fruits[l];
                rb = fruits[r];
            }
            r++;
        }

        return Math.max(max, r - l);
    }
}
