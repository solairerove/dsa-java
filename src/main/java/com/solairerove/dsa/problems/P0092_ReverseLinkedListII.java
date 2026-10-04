package com.solairerove.dsa.problems;

import com.solairerove.dsa.common.ListNode;

public class P0092_ReverseLinkedListII {

    // time O(n), space O(1)
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode sentinel = new ListNode(-1, head);
        ListNode prev = sentinel;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        prev.next = reverseKTimes(prev.next, right - left + 1);

        return sentinel.next;
    }

    private static ListNode reverseKTimes(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head.next = curr;

        return prev;
    }
}
