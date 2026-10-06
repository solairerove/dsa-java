package com.solairerove.dsa.problems;

import com.solairerove.dsa.common.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SuppressWarnings("NewClassNamingConvention")
class P0023_MergeKSortedListsTest {

    @Test
    void mergesThreeLists() {
        ListNode[] lists = {
                ListNode.fromList(List.of(1, 4, 5)),
                ListNode.fromList(List.of(1, 3, 4)),
                ListNode.fromList(List.of(2, 6)),
        };

        ListNode result = P0023_MergeKSortedLists.mergeKLists(lists);

        assertEquals(List.of(1, 1, 2, 3, 4, 4, 5, 6), ListNode.toList(result));
    }

    @Test
    void emptyArray() {
        assertNull(P0023_MergeKSortedLists.mergeKLists(new ListNode[]{}));
    }

    @Test
    void arrayWithSingleEmptyList() {
        ListNode[] lists = {null};

        assertNull(P0023_MergeKSortedLists.mergeKLists(lists));
    }

    @Test
    void singleList() {
        ListNode[] lists = {ListNode.fromList(List.of(1, 2, 3))};

        ListNode result = P0023_MergeKSortedLists.mergeKLists(lists);

        assertEquals(List.of(1, 2, 3), ListNode.toList(result));
    }

    @Test
    void allListsEmpty() {
        ListNode[] lists = {null, null, null};

        assertNull(P0023_MergeKSortedLists.mergeKLists(lists));
    }

    @Test
    void someListsEmpty() {
        ListNode[] lists = {
                null,
                ListNode.fromList(List.of(2, 5)),
                null,
                ListNode.fromList(List.of(1, 3)),
        };

        ListNode result = P0023_MergeKSortedLists.mergeKLists(lists);

        assertEquals(List.of(1, 2, 3, 5), ListNode.toList(result));
    }

    @Test
    void oddNumberOfLists() {
        ListNode[] lists = {
                ListNode.fromList(List.of(5)),
                ListNode.fromList(List.of(4)),
                ListNode.fromList(List.of(3)),
                ListNode.fromList(List.of(2)),
                ListNode.fromList(List.of(1)),
        };

        ListNode result = P0023_MergeKSortedLists.mergeKLists(lists);

        assertEquals(List.of(1, 2, 3, 4, 5), ListNode.toList(result));
    }

    @Test
    void negativesAndDuplicates() {
        ListNode[] lists = {
                ListNode.fromList(List.of(-10, -1, 0, 0)),
                ListNode.fromList(List.of(-5, 0, 7)),
                ListNode.fromList(List.of(-10, 7, 7)),
        };

        ListNode result = P0023_MergeKSortedLists.mergeKLists(lists);

        assertEquals(List.of(-10, -10, -5, -1, 0, 0, 0, 7, 7, 7), ListNode.toList(result));
    }

    @Test
    void listsOfDifferentLengths() {
        ListNode[] lists = {
                ListNode.fromList(List.of(1)),
                ListNode.fromList(List.of(0, 2, 4, 6, 8, 10)),
                ListNode.fromList(List.of(3, 9)),
        };

        ListNode result = P0023_MergeKSortedLists.mergeKLists(lists);

        assertEquals(List.of(0, 1, 2, 3, 4, 6, 8, 9, 10), ListNode.toList(result));
    }
}
