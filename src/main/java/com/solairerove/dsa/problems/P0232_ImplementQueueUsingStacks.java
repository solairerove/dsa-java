package com.solairerove.dsa.problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class P0232_ImplementQueueUsingStacks {

    private final Deque<Integer> s1;
    private final Deque<Integer> s2;

    public P0232_ImplementQueueUsingStacks() {
        s1 = new ArrayDeque<>();
        s2 = new ArrayDeque<>();
    }

    // time O(1), space O(1)
    public void push(int x) {
        s1.push(x);
    }

    // time O(n) worst case, amortized O(1), space O(1)
    public int pop() {
        reverse(s1, s2);

        return s2.pop();
    }

    // time O(n) worst case, amortized O(1), space O(1)
    public int peek() {
        reverse(s1, s2);

        return s2.peek();
    }

    // time O(1), space O(1)
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    private void reverse(Deque<Integer> s1, Deque<Integer> s2) {
        if (s2.isEmpty()) while (!s1.isEmpty()) s2.push(s1.pop());
    }
}
