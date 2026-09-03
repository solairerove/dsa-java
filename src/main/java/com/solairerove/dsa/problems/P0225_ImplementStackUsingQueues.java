package com.solairerove.dsa.problems;

import java.util.ArrayDeque;
import java.util.Queue;

public class P0225_ImplementStackUsingQueues {

    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public P0225_ImplementStackUsingQueues() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }

    // time O(n), space O(1)
    public void push(int x) {
        q2.offer(x);
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // time O(1), space O(1)
    public int pop() {
        return q1.poll();
    }

    // time O(1), space O(1)
    public int top() {
        return q1.peek();
    }

    // time O(1), space O(1)
    public boolean empty() {
        return q1.isEmpty();
    }
}
