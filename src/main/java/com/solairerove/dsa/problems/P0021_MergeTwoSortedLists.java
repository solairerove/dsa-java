package com.solairerove.dsa.problems;

import com.solairerove.dsa.common.ListNode;

public class P0021_MergeTwoSortedLists {

    // time O(n + m), space O(1)
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode sentinel = new ListNode(0);
        ListNode curr = sentinel;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        curr.next = (list1 != null) ? list1 : list2;

        return sentinel.next;
    }
}
