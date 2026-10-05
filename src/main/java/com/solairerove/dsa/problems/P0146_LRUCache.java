package com.solairerove.dsa.problems;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class P0146_LRUCache {

    private static class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> cache;
    private final Node head;
    private final Node tail;

    public P0146_LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);

        this.head.next = tail;
        this.tail.prev = head;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insertAtHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    // time O(1), space O(1)
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }

        remove(node);
        insertAtHead(node);

        return node.val;
    }

    // time O(1), space O(capacity)
    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            node.val = value;
            remove(node);
            insertAtHead(node);

            return;
        }

        node = new Node(key, value);
        cache.put(key, node);
        insertAtHead(node);

        if (cache.size() > capacity) {
            Node lru = tail.prev;
            remove(lru);
            cache.remove(lru.key);
        }
    }

    public static class LRUCacheLinkedHashMap {
        private final Map<Integer, Integer> cache;

        public LRUCacheLinkedHashMap(int capacity) {
            this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                    return size() > capacity;
                }
            };
        }

        // time O(1), space O(1)
        public int get(int key) {
            return cache.getOrDefault(key, -1);
        }

        // time O(1), space O(capacity)
        public void put(int key, int value) {
            cache.put(key, value);
        }
    }
}
