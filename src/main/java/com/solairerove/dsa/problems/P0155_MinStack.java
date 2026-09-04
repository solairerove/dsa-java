package com.solairerove.dsa.problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class P0155_MinStack {

    Deque<Integer> stack;
    Deque<Integer> prefixMin;

    public P0155_MinStack() {
        stack = new ArrayDeque<>();
        prefixMin = new ArrayDeque<>();
    }

    // time O(1), space O(n)
    public void push(int val) {
        stack.push(val);
        if (prefixMin.isEmpty() || val <= prefixMin.peek()) {
            prefixMin.push(val);
        }
    }

    // time O(1), space O(1)
    public void pop() {
        int top = stack.pop();
        if (top == prefixMin.peek()) {
            prefixMin.pop();
        }
    }

    // time O(1), space O(1)
    public int top() {
        return stack.peek();
    }

    // time O(1), space O(1)
    public int getMin() {
        return prefixMin.peek();
    }
}
