package com.solairerove.dsa.problems;

import com.solairerove.dsa.common.ListNode;

public class P0019_RemoveNthNodeFromEndOfList {

    // time O(n), space O(1)
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode(-1, head);
        ListNode prev = sentinel;
        ListNode curr = head;
        int k = n;
        while (curr != null) {
            if (--k < 0) {
                prev = prev.next;
            }

            curr = curr.next;
        }

        if (prev.next != null) {
            prev.next = prev.next.next;
        }

        return sentinel.next;
    }
}
