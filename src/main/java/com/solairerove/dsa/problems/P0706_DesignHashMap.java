package com.solairerove.dsa.problems;

public class P0706_DesignHashMap {

    private static class ListNode {
        int key;
        int val;
        ListNode next;

        public ListNode(int key, int val, ListNode next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }

        public ListNode() {
            this(-1, -1, null);
        }
    }

    private ListNode[] map;

    public P0706_DesignHashMap() {
        this.map = new ListNode[1000];
        for (int i = 0; i < 1000; i++) {
            map[i] = new ListNode();
        }
    }

    private int hash(int key) {
        return key % map.length;
    }

    // time O(n / k), space O(1)
    public void put(int key, int value) {
        ListNode curr = map[hash(key)];
        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next.val = value;
                return;
            }
            curr = curr.next;
        }
        curr.next = new ListNode(key, value, null);
    }

    // time O(n / k), space O(1)
    public int get(int key) {
        ListNode curr = map[hash(key)].next;
        while (curr != null) {
            if (curr.key == key) {
                return curr.val;
            }
            curr = curr.next;
        }

        return -1;
    }

    // time O(n / k), space O(1)
    public void remove(int key) {
        ListNode curr = map[hash(key)];
        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }
}
