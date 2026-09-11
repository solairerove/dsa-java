package com.solairerove.dsa.problems;

import java.util.HashMap;
import java.util.Map;

public class P0904_FruitIntoBaskets {

    // time O(n), space O(1)
    public static int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0;
        for (int fruit : fruits) {
            map.merge(fruit, 1, Integer::sum);

            if (map.size() > 2) {
                int left = fruits[l++];
                map.merge(left, -1, (a, b) -> a == 1 ? null : a + b);
            }
        }

        return fruits.length - l;
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
