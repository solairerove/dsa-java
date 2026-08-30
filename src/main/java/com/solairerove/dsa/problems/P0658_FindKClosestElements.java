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
    // time O(log(n - k) + k), space O(k)
    public static List<Integer> findClosestElementsBinarySearch(int[] arr, int k, int x) {
        int l = 0, r = arr.length - k;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (x - arr[m] > arr[m + k] - x) l = m + 1;
            else r = m;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = l; i < l + k; i++) res.add(arr[i]);

        return res;
    }
}
