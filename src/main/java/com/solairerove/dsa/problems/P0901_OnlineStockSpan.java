package com.solairerove.dsa.problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class P0901_OnlineStockSpan {

    final Deque<int[]> stack;

    public P0901_OnlineStockSpan() {
        stack = new ArrayDeque<>();
    }

    // time O(1) amortized, space O(n)
    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }
        stack.push(new int[]{price, span});

        return span;
    }
}
