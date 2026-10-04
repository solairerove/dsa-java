package com.solairerove.dsa.problems;

import com.solairerove.dsa.common.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.solairerove.dsa.common.ListNode.fromList;
import static com.solairerove.dsa.common.ListNode.toList;
import static com.solairerove.dsa.problems.P0143_ReorderList.reorderList;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0143_ReorderListTest {

    @Test
    void shouldReorderEvenLengthExampleOne() {
        ListNode head = fromList(List.of(1, 2, 3, 4));

        reorderList(head);

        assertEquals(List.of(1, 4, 2, 3), toList(head));
    }

    @Test
    void shouldReorderOddLengthExampleTwo() {
        ListNode head = fromList(List.of(1, 2, 3, 4, 5));

        reorderList(head);

        assertEquals(List.of(1, 5, 2, 4, 3), toList(head));
    }

    @Test
    void shouldLeaveSingleNodeUnchanged() {
        ListNode head = fromList(List.of(1));

        reorderList(head);

        assertEquals(List.of(1), toList(head));
    }

    @Test
    void shouldLeaveTwoNodesUnchanged() {
        ListNode head = fromList(List.of(1, 2));

        reorderList(head);

        assertEquals(List.of(1, 2), toList(head));
    }

    @Test
    void shouldReorderThreeNodes() {
        ListNode head = fromList(List.of(1, 2, 3));

        reorderList(head);

        assertEquals(List.of(1, 3, 2), toList(head));
    }

    @Test
    void shouldReorderSixNodes() {
        ListNode head = fromList(List.of(1, 2, 3, 4, 5, 6));

        reorderList(head);

        assertEquals(List.of(1, 6, 2, 5, 3, 4), toList(head));
    }

    @Test
    void shouldReorderSevenNodes() {
        ListNode head = fromList(List.of(1, 2, 3, 4, 5, 6, 7));

        reorderList(head);

        assertEquals(List.of(1, 7, 2, 6, 3, 5, 4), toList(head));
    }

    @Test
    void shouldReorderWithDuplicateValues() {
        ListNode head = fromList(List.of(5, 5, 1, 1));

        reorderList(head);

        assertEquals(List.of(5, 1, 5, 1), toList(head));
    }
}
