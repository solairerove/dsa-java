package com.solairerove.dsa.problems;

import com.solairerove.dsa.common.ListNode;

public class P0002_AddTwoNumbers {

    // time O(max(n, m)), space O(1) extra (output list O(max(n, m)))
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode();
        ListNode curr = sentinel;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;

            curr.next = node;
            curr = curr.next;
        }

        return sentinel.next;
    }
}
