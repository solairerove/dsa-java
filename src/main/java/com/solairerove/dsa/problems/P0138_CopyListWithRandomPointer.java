package com.solairerove.dsa.problems;

import java.util.HashMap;
import java.util.Map;

public class P0138_CopyListWithRandomPointer {

    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // time O(n), space O(n)
    public static Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();

        for (Node curr = head; curr != null; curr = curr.next) {
            map.put(curr, new Node(curr.val));
        }

        for (Node curr = head; curr != null; curr = curr.next) {
            Node copy = map.get(curr);
            copy.next = map.get(curr.next);
            copy.random = map.get(curr.random);
        }

        return map.get(head);
    }

    // time O(n), space O(1)
    public static Node copyRandomListInterleave(Node head) {
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            Node next = curr.next;
            curr.next = copy;
            copy.next = next;

            curr = next;
        }

        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        Node sentinel = new Node(-1);
        Node prev = sentinel;
        curr = head;
        while (curr != null) {
            Node copy = curr.next;
            prev.next = copy;
            prev = copy;

            curr.next = copy.next;
            curr = curr.next;
        }

        return sentinel.next;
    }
}
