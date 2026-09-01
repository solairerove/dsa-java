package com.solairerove.dsa.problems;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class P0239_SlidingWindowMaximum {

    // time O(n * log(n)), space O(n)
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int[] res = new int[n - k + 1];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            heap.offer(new int[]{nums[i], i});
            if (i >= k - 1) {
                while (heap.peek()[1] <= i - k) heap.poll();
                res[idx++] = heap.peek()[0];
            }
        }

        return res;
    }

    // time O(n), space O(k)
    public static int[] maxSlidingWindowDeque(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) dq.pollFirst();
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast();

            dq.offerLast(i);
            if (i >= k - 1) res[i - k + 1] = nums[dq.peekFirst()];
        }

        return res;
    }
}
