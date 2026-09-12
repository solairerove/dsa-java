package com.solairerove.dsa.problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class P0853_CarFleet {

    // time O(n * log n), space O(n)
    public static int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] pair = new int[n][2];
        for (int i = 0; i < n; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));

        Deque<Double> dq = new ArrayDeque<>();
        for (int[] p : pair) {
            double time = (double) (target - p[0]) / p[1];
            if (dq.isEmpty() || time > dq.peek()) {
                dq.push(time);
            }
        }

        return dq.size();
    }

    // time O(n + target), space O(target)
    public static int carFleetBucket(int target, int[] position, int[] speed) {
        int n = position.length;
        double[] time = new double[target + 1];
        for (int i = 0; i < n; i++) {
            time[position[i]] = (double) (target - position[i]) / speed[i];
        }

        int res = 0;
        double prev = time[target];
        for (int i = target - 1; i >= 0; i--) {
            if (time[i] > prev) {
                res++;
                prev = time[i];
            }
        }

        return res;
    }
}
