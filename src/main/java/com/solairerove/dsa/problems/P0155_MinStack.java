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
    // NOTE: the local `int top` is load-bearing, do not inline it.
    // Key: `==` is defined both for references and for primitives. `>=` is defined only for primitives.
    // stack.pop() returns Integer. prefixMin.peek() returns Integer.
    // - stack.pop() == prefixMin.peek() - both sides are Integer, so the compiler picks the reference
    //   version. That compares object addresses. No unboxing happens.
    // - prefixMin.peek() >= stack.pop() - no such operator exists for references, so the compiler is
    //   forced to unbox both to int. That compares values. Always correct.
    // - int top = stack.pop(); top == prefixMin.peek() - the left side is already int, so the right
    //   side gets unboxed too. Values again.
    // Why reference comparison still passes most tests: Integer.valueOf caches objects in -128..127.
    // For 5 or -100 both pushes store the very same cached object, the addresses match, and `==`
    // accidentally yields true. For 512 or -1024 there is no cache - stack.push(val) and
    // prefixMin.push(val) create two distinct objects holding equal values. `==` yields false,
    // prefixMin is never popped, and getMin returns a stale minimum.
    // The test [512, -1024, -1024, 512] targets exactly this hole - every value is outside the cache.
    // On the `>=` variant: the logic is correct because prefixMin.peek() is always <= the top of
    // stack, it can never be strictly greater, so `>=` fires exactly on equality. But it reads worse -
    // .intValue() or a local int states the intent plainly.
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
