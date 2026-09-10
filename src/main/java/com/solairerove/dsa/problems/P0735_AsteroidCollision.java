package com.solairerove.dsa.problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class P0735_AsteroidCollision {

    // time O(n), space O(n)
    public static int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> dq = new ArrayDeque<>();
        for (int a : asteroids) {
            while (!dq.isEmpty() && dq.peek() > 0 && a < 0) {
                int diff = dq.peek() + a;
                if (diff == 0) {
                    dq.pop();
                    a = 0;
                } else if (diff < 0) {
                    dq.pop();
                } else {
                    a = 0;
                }
            }

            if (a != 0) {
                dq.push(a);
            }
        }

        int[] res = new int[dq.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = dq.pop();
        }

        return res;
    }

    // time O(n), space O(1)
    public static int[] asteroidCollisionInPlace(int[] asteroids) {
        int top = -1;
        for (int a : asteroids) {
            while (top >= 0 && asteroids[top] > 0 && a < 0) {
                int diff = asteroids[top] + a;
                if (diff == 0) {
                    top--;
                    a = 0;
                } else if (diff < 0) {
                    top--;
                } else {
                    a = 0;
                }
            }

            if (a != 0) {
                asteroids[++top] = a;
            }
        }

        return Arrays.copyOfRange(asteroids, 0, top + 1);
    }
}
