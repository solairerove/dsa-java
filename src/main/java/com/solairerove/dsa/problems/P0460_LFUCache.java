package com.solairerove.dsa.problems;

import java.util.HashMap;
import java.util.Map;

public class P0460_LFUCache {

    private static class Node {
        int key;
        int val;
        int freq;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }

    private static class DLL {
        final Node head;
        final Node tail;

        DLL() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);

            head.next = tail;
            tail.prev = head;
        }

        void remove(Node node) {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        void insertAtHead(Node node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        Node removeFromTail() {
            Node lru = tail.prev;
            remove(lru);

            return lru;
        }

        boolean isEmpty() {
            return head.next == tail;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> cache;
    private final Map<Integer, DLL> freqs;
    private int minFreq;

    public P0460_LFUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.freqs = new HashMap<>();
    }

    // time O(1), space O(1)
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }

        touch(node);

        return node.val;
    }

    // time O(1), space O(capacity)
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        Node node = cache.get(key);
        if (node != null) {
            node.val = value;
            touch(node);

            return;
        }

        if (cache.size() == capacity) {
            DLL bucket = freqs.get(minFreq);
            Node lru = bucket.removeFromTail();
            cache.remove(lru.key);
            if (bucket.isEmpty()) {
                freqs.remove(minFreq);
            }
        }

        node = new Node(key, value);
        cache.put(key, node);
        freqs.computeIfAbsent(1, f -> new DLL()).insertAtHead(node);
        minFreq = 1;
    }

    private void touch(Node node) {
        DLL bucket = freqs.get(node.freq);
        bucket.remove(node);
        if (bucket.isEmpty()) {
            freqs.remove(node.freq);
            if (node.freq == minFreq) {
                minFreq++;
            }
        }
        node.freq++;
        freqs.computeIfAbsent(node.freq, f -> new DLL()).insertAtHead(node);
    }
}
