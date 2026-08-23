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

    private static void quickSelect(int[] arr, int i, int j, int k, Map<Integer, Integer> freq) {
        if (i >= j) return;

        int pivot = partition(arr, i, j, freq);
        if (pivot == k) return;
        if (pivot < k) quickSelect(arr, pivot + 1, j, k, freq);
        else quickSelect(arr, i, pivot - 1, k, freq);
    }

    private static int partition(int[] arr, int low, int high, Map<Integer, Integer> freq) {
        int pivot = freq.get(arr[high]);
        int i = low;
        for (int j = low; j < high; j++) {
            if (freq.get(arr[j]) < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, high);

        return i;
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
