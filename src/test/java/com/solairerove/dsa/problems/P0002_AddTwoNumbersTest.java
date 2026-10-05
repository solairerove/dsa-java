package com.solairerove.dsa.problems;

import com.solairerove.dsa.common.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0002_AddTwoNumbersTest {

    @Test
    void addsLeetCodeExample() {
        ListNode l1 = ListNode.fromList(List.of(2, 4, 3));
        ListNode l2 = ListNode.fromList(List.of(5, 6, 4));

        ListNode result = P0002_AddTwoNumbers.addTwoNumbers(l1, l2);

        assertEquals(List.of(7, 0, 8), ListNode.toList(result));
    }

    @Test
    void addsZeros() {
        ListNode l1 = ListNode.fromList(List.of(0));
        ListNode l2 = ListNode.fromList(List.of(0));

        ListNode result = P0002_AddTwoNumbers.addTwoNumbers(l1, l2);

        assertEquals(List.of(0), ListNode.toList(result));
    }

    @Test
    void propagatesCarryThroughLongerList() {
        ListNode l1 = ListNode.fromList(List.of(9, 9, 9, 9, 9, 9, 9));
        ListNode l2 = ListNode.fromList(List.of(9, 9, 9, 9));

        ListNode result = P0002_AddTwoNumbers.addTwoNumbers(l1, l2);

        assertEquals(List.of(8, 9, 9, 9, 0, 0, 0, 1), ListNode.toList(result));
    }

    @Test
    void addsWhenFirstListShorter() {
        ListNode l1 = ListNode.fromList(List.of(1));
        ListNode l2 = ListNode.fromList(List.of(2, 3, 4));

        ListNode result = P0002_AddTwoNumbers.addTwoNumbers(l1, l2);

        assertEquals(List.of(3, 3, 4), ListNode.toList(result));
    }

    @Test
    void addsWhenSecondListShorter() {
        ListNode l1 = ListNode.fromList(List.of(5, 6, 7));
        ListNode l2 = ListNode.fromList(List.of(5));

        ListNode result = P0002_AddTwoNumbers.addTwoNumbers(l1, l2);

        assertEquals(List.of(0, 7, 7), ListNode.toList(result));
    }

    @Test
    void appendsFinalCarryNode() {
        ListNode l1 = ListNode.fromList(List.of(5));
        ListNode l2 = ListNode.fromList(List.of(5));

        ListNode result = P0002_AddTwoNumbers.addTwoNumbers(l1, l2);

        assertEquals(List.of(0, 1), ListNode.toList(result));
    }

    @Test
    void carryInMiddleWithoutFinalCarry() {
        ListNode l1 = ListNode.fromList(List.of(8, 1));
        ListNode l2 = ListNode.fromList(List.of(4, 2));

        ListNode result = P0002_AddTwoNumbers.addTwoNumbers(l1, l2);

        assertEquals(List.of(2, 4), ListNode.toList(result));
    }

    @Test
    void addsSingleDigitsWithoutCarry() {
        ListNode l1 = ListNode.fromList(List.of(3));
        ListNode l2 = ListNode.fromList(List.of(4));

        ListNode result = P0002_AddTwoNumbers.addTwoNumbers(l1, l2);

        assertEquals(List.of(7), ListNode.toList(result));
    }
}
