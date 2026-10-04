package com.solairerove.dsa.problems;

import com.solairerove.dsa.common.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.solairerove.dsa.common.ListNode.fromList;
import static com.solairerove.dsa.common.ListNode.toList;
import static com.solairerove.dsa.problems.P0092_ReverseLinkedListII.reverseBetween;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0092_ReverseLinkedListIITest {

    @Test
    void shouldReverseMiddleSegmentExampleOne() {
        ListNode result = reverseBetween(fromList(List.of(1, 2, 3, 4, 5)), 2, 4);

        assertEquals(List.of(1, 4, 3, 2, 5), toList(result));
    }

    @Test
    void shouldHandleSingleNodeExampleTwo() {
        ListNode result = reverseBetween(fromList(List.of(5)), 1, 1);

        assertEquals(List.of(5), toList(result));
    }

    @Test
    void shouldReverseWholeList() {
        ListNode result = reverseBetween(fromList(List.of(1, 2, 3, 4, 5)), 1, 5);

        assertEquals(List.of(5, 4, 3, 2, 1), toList(result));
    }

    @Test
    void shouldReversePrefix() {
        ListNode result = reverseBetween(fromList(List.of(1, 2, 3, 4, 5)), 1, 3);

        assertEquals(List.of(3, 2, 1, 4, 5), toList(result));
    }

    @Test
    void shouldReverseSuffix() {
        ListNode result = reverseBetween(fromList(List.of(1, 2, 3, 4, 5)), 3, 5);

        assertEquals(List.of(1, 2, 5, 4, 3), toList(result));
    }

    @Test
    void shouldLeaveListUnchangedWhenLeftEqualsRight() {
        ListNode result = reverseBetween(fromList(List.of(1, 2, 3, 4, 5)), 3, 3);

        assertEquals(List.of(1, 2, 3, 4, 5), toList(result));
    }

    @Test
    void shouldReverseTwoNodeList() {
        ListNode result = reverseBetween(fromList(List.of(3, 5)), 1, 2);

        assertEquals(List.of(5, 3), toList(result));
    }

    @Test
    void shouldReverseAdjacentPair() {
        ListNode result = reverseBetween(fromList(List.of(1, 2, 3, 4, 5)), 2, 3);

        assertEquals(List.of(1, 3, 2, 4, 5), toList(result));
    }

    @Test
    void shouldReverseWithNegativeValues() {
        ListNode result = reverseBetween(fromList(List.of(-1, -2, -3, -4)), 2, 4);

        assertEquals(List.of(-1, -4, -3, -2), toList(result));
    }
}
