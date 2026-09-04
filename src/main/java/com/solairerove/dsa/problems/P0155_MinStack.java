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

    public static class MinStackLinkedList {

        private static class Node {
            int val;
            int min;
            Node next;

            private Node(int val, int min, Node next) {
                this.val = val;
                this.min = min;
                this.next = next;
            }
        }

        private Node head;

        public MinStackLinkedList() {

        }

        // time O(1), space O(1)
        public void push(int value) {
            if (head == null) {
                head = new Node(value, value, null);
            } else {
                head = new Node(value, Math.min(value, head.min), head);
            }
        }

        // time O(1), space O(1)
        public void pop() {
            head = head.next;
        }

        // time O(1), space O(1)
        public int top() {
            return head.val;
        }

        // time O(1), space O(1)
        public int getMin() {
            return head.min;
        }
    }
}
