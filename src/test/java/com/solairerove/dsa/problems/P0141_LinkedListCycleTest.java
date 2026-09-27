package com.solairerove.dsa.problems;

import com.solairerove.dsa.common.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("NewClassNamingConvention")
class P0141_LinkedListCycleTest {

    // builds list and links tail to node at index pos (-1 means no cycle)
    private static ListNode withCycle(List<Integer> values, int pos) {
        ListNode head = ListNode.fromList(values);
        if (head == null || pos < 0) {
            return head;
        }

        ListNode target = head, tail = head;
        for (int i = 0; i < pos; i++) {
            target = target.next;
        }
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = target;
        return head;
    }

    @Test
    void cycleToSecondNode() {
        assertTrue(P0141_LinkedListCycle.hasCycle(withCycle(List.of(3, 2, 0, -4), 1)));
    }

    @Test
    void twoNodesCycleToHead() {
        assertTrue(P0141_LinkedListCycle.hasCycle(withCycle(List.of(1, 2), 0)));
    }

    @Test
    void singleNodeNoCycle() {
        assertFalse(P0141_LinkedListCycle.hasCycle(withCycle(List.of(1), -1)));
    }

    @Test
    void emptyList() {
        assertFalse(P0141_LinkedListCycle.hasCycle(null));
    }

    @Test
    void singleNodeSelfLoop() {
        assertTrue(P0141_LinkedListCycle.hasCycle(withCycle(List.of(1), 0)));
    }

    @Test
    void longListNoCycle() {
        assertFalse(P0141_LinkedListCycle.hasCycle(withCycle(List.of(1, 2, 3, 4, 5, 6), -1)));
    }

    @Test
    void oddLengthNoCycle() {
        assertFalse(P0141_LinkedListCycle.hasCycle(withCycle(List.of(1, 2, 3), -1)));
    }

    @Test
    void cycleTailToItself() {
        assertTrue(P0141_LinkedListCycle.hasCycle(withCycle(List.of(1, 2, 3, 4, 5), 4)));
    }

    @Test
    void cycleToHeadLongList() {
        assertTrue(P0141_LinkedListCycle.hasCycle(withCycle(List.of(1, 2, 3, 4, 5, 6, 7), 0)));
    }
}
