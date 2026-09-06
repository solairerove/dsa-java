package com.solairerove.dsa.problems;

import java.util.Arrays;
import java.util.Stack;

public class P0735_AsteroidCollision {

    // time O(n), space O(n)
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int a : asteroids) {
            while (!stack.isEmpty() && a < 0 && stack.peek() > 0) {
                int diff = a + stack.peek();
                if (diff < 0) {
                    stack.pop();
                } else if (diff > 0) {
                    a = 0;
                } else {
                    a = 0;
                    stack.pop();
                }
            }
            if (a != 0) {
                stack.add(a);
            }
        }

        return stack.stream().mapToInt(i -> i).toArray();
    }

    // time O(n), space O(1)
    public static int[] asteroidCollisionInPlace(int[] asteroids) {
        int i = -1;
        for (int a : asteroids) {
            while (i >= 0 && asteroids[i] > 0 && a < 0) {
                if (asteroids[i] > Math.abs(a)) {
                    a = 0;
                    break;
                } else if (asteroids[i] == Math.abs(a)) {
                    i--;
                    a = 0;
                    break;
                } else {
                    i--;
                }
            }
            if (a != 0) {
                asteroids[++i] = a;
            }
        }

        return Arrays.copyOfRange(asteroids, 0, i + 1);
    }
}
