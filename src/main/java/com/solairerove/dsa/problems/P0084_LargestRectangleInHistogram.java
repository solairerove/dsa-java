package com.solairerove.dsa.problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class P0084_LargestRectangleInHistogram {

    // time O(n), space O(n)
    public static int largestRectangleArea(int[] heights) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.push(-1);

        int n = heights.length;
        int maxArea = 0;
        for (int i = 0; i <= n; i++) {
            int currentHeight = i == n ? 0 : heights[i];
            while (dq.peek() != -1 && heights[dq.peek()] >= currentHeight) {
                int height = heights[dq.pop()];
                int width = i - dq.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
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
