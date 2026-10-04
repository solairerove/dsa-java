package com.solairerove.dsa.problems;

import com.solairerove.dsa.common.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.solairerove.dsa.common.ListNode.fromList;
import static com.solairerove.dsa.common.ListNode.toList;
import static com.solairerove.dsa.problems.P0019_RemoveNthNodeFromEndOfList.removeNthFromEnd;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0019_RemoveNthNodeFromEndOfListTest {

    @Test
    void shouldRemoveSecondFromEndExampleOne() {
        ListNode result = removeNthFromEnd(fromList(List.of(1, 2, 3, 4, 5)), 2);

        assertEquals(List.of(1, 2, 3, 5), toList(result));
    }

    @Test
    void shouldRemoveOnlyNodeExampleTwo() {
        ListNode result = removeNthFromEnd(fromList(List.of(1)), 1);

        assertEquals(List.of(), toList(result));
    }

    @Test
    void shouldRemoveLastNodeExampleThree() {
        ListNode result = removeNthFromEnd(fromList(List.of(1, 2)), 1);

        assertEquals(List.of(1), toList(result));
    }

    @Test
    void shouldRemoveHeadOfTwoNodeList() {
        ListNode result = removeNthFromEnd(fromList(List.of(1, 2)), 2);

        assertEquals(List.of(2), toList(result));
    }

    @Test
    void shouldRemoveHead() {
        ListNode result = removeNthFromEnd(fromList(List.of(1, 2, 3, 4, 5)), 5);

        assertEquals(List.of(2, 3, 4, 5), toList(result));
    }

    @Test
    void shouldRemoveTail() {
        ListNode result = removeNthFromEnd(fromList(List.of(1, 2, 3, 4, 5)), 1);

        assertEquals(List.of(1, 2, 3, 4), toList(result));
    }

    @Test
    void shouldRemoveMiddle() {
        ListNode result = removeNthFromEnd(fromList(List.of(1, 2, 3, 4, 5)), 3);

        assertEquals(List.of(1, 2, 4, 5), toList(result));
    }

    @Test
    void shouldRemoveWithDuplicateValues() {
        ListNode result = removeNthFromEnd(fromList(List.of(7, 7, 7, 7)), 2);

        assertEquals(List.of(7, 7, 7), toList(result));
    }

    @Test
    void shouldRemoveWithZeroValues() {
        ListNode result = removeNthFromEnd(fromList(List.of(0, 0, 1)), 3);

        assertEquals(List.of(0, 1), toList(result));
    }
}
