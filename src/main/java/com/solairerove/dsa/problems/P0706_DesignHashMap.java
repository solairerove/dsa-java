package com.solairerove.dsa.problems;

public class P0706_DesignHashMap {

    private static class Node {
        int key;
        int val;
        Node next;

        Node() {
        }

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    final Node[] map;

    public P0706_DesignHashMap() {
        map = new Node[1 << 10];
        for (int i = 0; i < map.length; i++) {
            map[i] = new Node();
        }
    }

    private int hash(int key) {
        return key & (map.length - 1);
    }

    // time O(n / k), space O(1)
    public void put(int key, int value) {
        Node curr = map[hash(key)];
        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next.val = value;
                return;
            }
            curr = curr.next;
        }
        curr.next = new Node(key, value);
    }

    // time O(n / k), space O(1)
    public int get(int key) {
        Node curr = map[hash(key)];
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
        Node curr = map[hash(key)];
        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }
}
