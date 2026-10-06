package com.solairerove.dsa.problems;

import com.solairerove.dsa.common.ListNode;

public class P0023_MergeKSortedLists {

    // time O(N log k), space O(1)
    public static ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) {
            return null;
        }

        int interval = 1;
        while (interval < n) {
            for (int i = 0; i + interval < n; i += interval * 2) {
                lists[i] = merge(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }

        return lists[0];
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode();
        ListNode curr = sentinel;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        curr.next = (l1 != null) ? l1 : l2;

        return sentinel.next;
    }
}
