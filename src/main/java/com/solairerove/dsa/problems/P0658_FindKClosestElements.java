package com.solairerove.dsa.problems;

import java.util.ArrayList;
import java.util.List;

public class P0658_FindKClosestElements {

    // time O(n - k), space O(k)
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, r = arr.length - 1;
        while (r - l >= k) {
            if (Math.abs(x - arr[l]) <= Math.abs(x - arr[r])) r--;
            else l++;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = l; i <= r; i++) res.add(arr[i]);

        return res;
    }
}
