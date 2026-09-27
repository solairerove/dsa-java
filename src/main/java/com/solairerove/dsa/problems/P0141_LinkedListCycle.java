package com.solairerove.dsa.problems;

import com.solairerove.dsa.common.ListNode;

public class P0141_LinkedListCycle {

    // time O(n), space O(1)
    public static boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
