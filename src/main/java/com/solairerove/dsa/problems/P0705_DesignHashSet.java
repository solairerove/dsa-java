package com.solairerove.dsa.problems;

public class P0705_DesignHashSet {

    private static class ListNode {
        int key;
        ListNode next;

        ListNode(int key) {
            this.key = key;
        }
    }

    private final ListNode[] set;

    public P0705_DesignHashSet() {
        set = new ListNode[10000];
        for (int i = 0; i < set.length; i++) {
            set[i] = new ListNode(0);
        }
    }

    private int hash(int key) {
        return key % set.length;
    }

    // time O(n / k), space O(1)
    public void add(int key) {
        ListNode curr = set[hash(key)];
        while (curr.next != null) {
            if (curr.next.key == key) {
                return;
            }
            curr = curr.next;
        }
        curr.next = new ListNode(key);
    }

    // time O(n / k), space O(1)
    public void remove(int key) {
        ListNode curr = set[hash(key)];
        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }

    // time O(n / k), space O(1)
    public boolean contains(int key) {
        ListNode curr = set[hash(key)];
        while (curr.next != null) {
            if (curr.next.key == key) {
                return true;
            }
            curr = curr.next;
        }

        return false;
    }
}
