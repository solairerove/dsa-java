package com.solairerove.dsa.problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;

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

    // time O(n + k * d), space O(d), d = distinct values in nums
    public static int[] topKFrequentNaive(int[] nums, int k) {
        // naive approach
        // count frequency using haspmap
        // iterate this map k times each time finding max frequence
        // add in to res [], and continue to iterate again filtering freq by res
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.merge(num, 1, Integer::sum);
        }

        Set<Integer> seen = new HashSet<>();
        int[] res = new int[k];
        for (int j = 0; j < k; j++) {
            int maxV = 0;
            int maxK = nums[0];
            for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
                if (!seen.contains(e.getKey()) && e.getValue() > maxV) {
                    maxV = e.getValue();
                    maxK = e.getKey();
                }
            }
            if (seen.add(maxK)) {
                res[j] = maxK;
            }
        }

        return res;
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
