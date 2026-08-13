package com.solairerove.dsa.problems;

public class P0706_DesignHashMap {

    private static class ListNode {
        private final int key;
        private int val;
        private ListNode next;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private final ListNode[] map;

    public P0706_DesignHashMap() {
        map = new ListNode[10000];
        for (int i = 0; i < map.length; i++) {
            map[i] = new ListNode(-1, -1);
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
        curr.next = new ListNode(key, value);
    }

    // time O(n / k), space O(1)
    public int get(int key) {
        ListNode curr = map[hash(key)];
        while (curr.next != null) {
            if (curr.next.key == key) {
                return curr.next.val;
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
