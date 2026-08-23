package com.solairerove.dsa.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class P0347_TopKFrequentElements {

    // time O(n), space O(n)
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int n : nums) {
            cnt.merge(n, 1, Integer::sum);
        }

        List<List<Integer>> freq = new ArrayList<>(nums.length + 1);
        for (int i = 0; i <= nums.length + 1; i++) {
            freq.add(null);
        }

        for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {
            int f = e.getValue();
            if (freq.get(f) == null) {
                freq.set(f, new ArrayList<>());
            }
            freq.get(f).add(e.getKey());
        }

        int[] res = new int[k];
        int idx = 0;
        for (int i = nums.length; i > 0; i--) {
            List<Integer> bucket = freq.get(i);
            if (bucket == null) {
                continue;
            }
            for (int n : bucket) {
                res[idx++] = n;
                if (idx == k) {
                    return res;
                }
            }
        }

        return res;
    }

    // time O(d) average / O(d^2) worst, space O(d), d = distinct values in nums
    public static int[] topKFrequentQuickSelect(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.merge(n, 1, Integer::sum);
        }
        int[] arr = freq.keySet().stream()
                .mapToInt(i -> i)
                .toArray();
        quickSelect(arr, 0, arr.length - 1, arr.length - k, freq);
        return Arrays.copyOfRange(arr, arr.length - k, arr.length);
    }

    private static void quickSelect(int[] arr, int lo, int hi, int k, Map<Integer, Integer> freq) {
        if (lo >= hi) return;

        int[] mid = partition(arr, lo, hi, freq);
        if (k < mid[0]) quickSelect(arr, lo, mid[0] - 1, k, freq);
        else if (k > mid[1]) quickSelect(arr, mid[1] + 1, hi, k, freq);
    }

    // dutch national flag: returns bounds of the block whose frequency equals the pivot's
    private static int[] partition(int[] arr, int lo, int hi, Map<Integer, Integer> freq) {
        int pivot = freq.get(arr[lo + (hi - lo) / 2]);
        int l = lo, i = lo, r = hi;
        while (i <= r) {
            int f = freq.get(arr[i]);
            if (f < pivot) {
                swap(arr, l++, i++);
            } else if (f > pivot) {
                swap(arr, i, r--);
            } else {
                i++;
            }
        }

        return new int[]{l, r};
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // time O(d * log(k)), space O(d + k), d = distinct values in nums
    public static int[] topKFrequentHeap(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.merge(num, 1, Integer::sum);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            heap.offer(new int[]{entry.getValue(), entry.getKey()});
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = Objects.requireNonNull(heap.poll())[1];
        }

        return res;
    }
}
