package com.solairerove.dsa.problems;

public class P0622_DesignCircularQueue {

    private static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;
    private final int capacity;
    private int size;

    public P0622_DesignCircularQueue(int k) {
        capacity = k;
    }

    // time O(1), space O(1)
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        Node node = new Node(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }

        size++;

        return true;
    }

    // time O(1), space O(1)
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        head = head.next;
        if (--size == 0) {
            tail = null;
        }

        return true;
    }

    // time O(1), space O(1)
    public int Front() {
        return isEmpty() ? -1 : head.val;
    }

    // time O(1), space O(1)
    public int Rear() {
        return isEmpty() ? -1 : tail.val;
    }

    // time O(1), space O(1)
    public boolean isEmpty() {
        return size == 0;
    }

    // time O(1), space O(1)
    public boolean isFull() {
        return capacity == size;
    }
}
