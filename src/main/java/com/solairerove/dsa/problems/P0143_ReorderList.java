package com.solairerove.dsa.problems;

import com.solairerove.dsa.common.ListNode;

public class P0143_ReorderList {

    // time O(n), space O(1)
    public static void reorderList(ListNode head) {
        // find middle
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse second half
        ListNode prev = null;
        ListNode curr = slow;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // reorder
        ListNode curr1 = head;
        ListNode curr2 = prev;
        while (curr1 != null && curr2 != null) {
            ListNode next1 = curr1.next;
            ListNode next2 = curr2.next;

            curr1.next = curr2;
            curr2.next = next1;

            curr1 = next1;
            curr2 = next2;
        }
    }
}
