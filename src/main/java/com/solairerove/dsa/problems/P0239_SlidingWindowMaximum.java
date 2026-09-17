package com.solairerove.dsa.problems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class P0239_SlidingWindowMaximum {

    // time O(n), space O(k)
    public static int[] maxSlidingWindowDeque(int[] nums, int k) {
        int n = nums.length;

        Deque<Integer> dq = new ArrayDeque<>();
        int[] res = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && dq.peekFirst() < i - k + 1) dq.pollFirst();

            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast();

            dq.offerLast(i);
            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[dq.peekFirst()];
            }
        }

        return res;
    }

    // time O(n * log(n)), space O(n)
    public static int[] maxSlidingWindowHeap(int[] nums, int k) {
        int n = nums.length;

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int[] res = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            while (!heap.isEmpty() && heap.peek()[1] < i - k + 1) heap.poll();

            heap.offer(new int[] {nums[i], i});
            if (i - k + 1 >= 0) {
                res[i - k + 1] = heap.peek()[0];
            }
        }

        return res;
    }
}
