package com.solairerove.dsa.problems;

import com.solairerove.dsa.common.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P0021_MergeTwoSortedListsTest {

    @Test
    void mergesTwoInterleavedLists() {
        ListNode l1 = ListNode.fromList(List.of(1, 2, 4));
        ListNode l2 = ListNode.fromList(List.of(1, 3, 4));

        ListNode result = P0021_MergeTwoSortedLists.mergeTwoLists(l1, l2);

        assertEquals(List.of(1, 1, 2, 3, 4, 4), ListNode.toList(result));
    }

    @Test
    void bothListsEmpty() {
        ListNode result = P0021_MergeTwoSortedLists.mergeTwoLists(null, null);

        assertEquals(List.of(), ListNode.toList(result));
    }

    @Test
    void oneListEmpty() {
        ListNode l1 = ListNode.fromList(List.of());
        ListNode l2 = ListNode.fromList(List.of(0));

        ListNode result = P0021_MergeTwoSortedLists.mergeTwoLists(l1, l2);

        assertEquals(List.of(0), ListNode.toList(result));
    }
}
