package com.solairerove.dsa.problems;

import java.util.Arrays;
import java.util.Stack;

public class P0853_CarFleet {

    // time O(n * log n), space O(n)
    public static int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> dq = new Stack<>();

        int n = position.length;
        int[][] pair = new int[n][2];
        for (int i = 0; i < n; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));

        for (int[] p : pair) {
            dq.push((double) (target - p[0]) / p[1]);
            if (dq.size() >= 2 && dq.peek() <= dq.get(dq.size() - 2)) {
                dq.pop();
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
