package com.solairerove.dsa.problems;

import com.solairerove.dsa.common.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0206_ReverseLinkedListTest {

    @Test
    void reversesFiveElementList() {
        ListNode head = ListNode.fromList(List.of(1, 2, 3, 4, 5));

        ListNode result = P0206_ReverseLinkedList.reverseList(head);

        assertEquals(List.of(5, 4, 3, 2, 1), ListNode.toList(result));
    }

    @Test
    void reversesTwoElementList() {
        ListNode head = ListNode.fromList(List.of(1, 2));

        ListNode result = P0206_ReverseLinkedList.reverseList(head);

        assertEquals(List.of(2, 1), ListNode.toList(result));
    }

    @Test
    void emptyList() {
        ListNode result = P0206_ReverseLinkedList.reverseList(null);

        assertEquals(List.of(), ListNode.toList(result));
    }

    @Test
    void singleElement() {
        ListNode head = ListNode.fromList(List.of(7));

        ListNode result = P0206_ReverseLinkedList.reverseList(head);

        assertEquals(List.of(7), ListNode.toList(result));
    }

    @Test
    void duplicatesAndNegatives() {
        ListNode head = ListNode.fromList(List.of(-1, 0, 0, 3, -1));

        ListNode result = P0206_ReverseLinkedList.reverseList(head);

        assertEquals(List.of(-1, 3, 0, 0, -1), ListNode.toList(result));
    }

    @Test
    void oldHeadBecomesTail() {
        ListNode head = ListNode.fromList(List.of(1, 2, 3));

        P0206_ReverseLinkedList.reverseList(head);

        assertEquals(List.of(1), ListNode.toList(head));
    }
}
