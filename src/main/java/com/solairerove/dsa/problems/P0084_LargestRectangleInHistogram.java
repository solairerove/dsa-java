package com.solairerove.dsa.problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class P0084_LargestRectangleInHistogram {

    // time O(n), space O(n)
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length, maxArea = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            while (!dq.isEmpty() && (i == n || heights[dq.peek()] >= heights[i])) {
                int h = heights[dq.pop()];
                int w = dq.isEmpty() ? i : i - dq.peek() - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            dq.push(i);
        }

        return maxArea;
    }

    // time O(n), space O(n)
    public static int largestRectangleAreaArray(int[] heights) {
        int n = heights.length;
        int[] stack = new int[n + 1];
        int top = -1, res = 0;
        for (int i = 0; i < n + 1; i++) {
            int curr = i == n ? 0 : heights[i];
            while (top >= 0 && heights[stack[top]] > curr) {
                int height = heights[stack[top--]];
                int width = top < 0 ? -1 : stack[top];
                res = Math.max(res, height * (i - width - 1));
            }
            stack[++top] = i;
        }

        return res;
    }
}
