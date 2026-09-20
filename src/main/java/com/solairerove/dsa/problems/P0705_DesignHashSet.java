package com.solairerove.dsa.problems;

public class P0705_DesignHashSet {

    private static class Node {
        int key;
        Node next;

        Node() {
        }

        Node(int key) {
            this.key = key;
        }
    }

    private final Node[] set;

    public P0705_DesignHashSet() {
        set = new Node[1 << 10];
        for (int i = 0; i < set.length; i++) {
            set[i] = new Node();
        }
    }

    private int hash(int key) {
        return key & (set.length - 1);
    }

    private Node findPrev(int key) {
        Node curr = set[hash(key)];
        while (curr.next != null && curr.next.key != key) {
            curr = curr.next;
        }

        return curr;
    }

    // time O(n / k), space O(1)
    public void add(int key) {
        Node prev = findPrev(key);
        if (prev.next == null) {
            prev.next = new Node(key);
        }
    }

    // time O(n / k), space O(1)
    public void remove(int key) {
        Node prev = findPrev(key);
        if (prev.next != null) {
            prev.next = prev.next.next;
        }
    }

    // time O(n / k), space O(1)
    public boolean contains(int key) {
        return findPrev(key).next != null;
    }
}
