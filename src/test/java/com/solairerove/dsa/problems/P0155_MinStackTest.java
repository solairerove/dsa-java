package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0155_MinStackTest {

    @Test
    void followsLeetCodeExample() {
        P0155_MinStack stack = new P0155_MinStack();

        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        assertEquals(-3, stack.getMin());
        stack.pop();
        assertEquals(0, stack.top());
        assertEquals(-2, stack.getMin());
    }

    @Test
    void singleElement() {
        P0155_MinStack stack = new P0155_MinStack();

        stack.push(5);
        assertEquals(5, stack.top());
        assertEquals(5, stack.getMin());
    }

    @Test
    void minUpdatesOnDescendingPushes() {
        P0155_MinStack stack = new P0155_MinStack();

        stack.push(5);
        assertEquals(5, stack.getMin());
        stack.push(3);
        assertEquals(3, stack.getMin());
        stack.push(1);
        assertEquals(1, stack.getMin());
    }

    @Test
    void minStaysOnAscendingPushes() {
        P0155_MinStack stack = new P0155_MinStack();

        stack.push(1);
        stack.push(3);
        stack.push(5);
        assertEquals(1, stack.getMin());
        assertEquals(5, stack.top());
    }

    @Test
    void minRestoredAfterPops() {
        P0155_MinStack stack = new P0155_MinStack();

        stack.push(2);
        stack.push(1);
        assertEquals(1, stack.getMin());
        stack.pop();
        assertEquals(2, stack.getMin());
        assertEquals(2, stack.top());
    }

    @Test
    void duplicateMinsHandled() {
        P0155_MinStack stack = new P0155_MinStack();

        stack.push(1);
        stack.push(1);
        stack.push(2);
        assertEquals(1, stack.getMin());
        stack.pop();
        assertEquals(1, stack.getMin());
        stack.pop();
        assertEquals(1, stack.getMin());
        assertEquals(1, stack.top());
    }

    @Test
    void popOnEmptyIsNoOp() {
        P0155_MinStack stack = new P0155_MinStack();

        stack.pop();
        stack.push(4);
        assertEquals(4, stack.top());
        assertEquals(4, stack.getMin());
    }

    @Test
    void reusableAfterEmptying() {
        P0155_MinStack stack = new P0155_MinStack();

        stack.push(3);
        stack.push(1);
        stack.pop();
        stack.pop();

        stack.push(7);
        assertEquals(7, stack.top());
        assertEquals(7, stack.getMin());
    }

    @Test
    void topDoesNotRemove() {
        P0155_MinStack stack = new P0155_MinStack();

        stack.push(8);
        assertEquals(8, stack.top());
        assertEquals(8, stack.top());
        stack.pop();
        stack.push(9);
        assertEquals(9, stack.top());
    }

    @Test
    void negativeAndPositiveMix() {
        P0155_MinStack stack = new P0155_MinStack();

        stack.push(0);
        stack.push(-1);
        stack.push(4);
        stack.push(-7);
        assertEquals(-7, stack.getMin());
        stack.pop();
        assertEquals(-1, stack.getMin());
        stack.pop();
        assertEquals(-1, stack.getMin());
        stack.pop();
        assertEquals(0, stack.getMin());
    }

    @Test
    void extremeValues() {
        P0155_MinStack stack = new P0155_MinStack();

        stack.push(Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE, stack.getMin());
        stack.push(Integer.MIN_VALUE);
        assertEquals(Integer.MIN_VALUE, stack.getMin());
        assertEquals(Integer.MIN_VALUE, stack.top());
        stack.pop();
        assertEquals(Integer.MAX_VALUE, stack.getMin());
    }

    @Test
    void manyElements() {
        P0155_MinStack stack = new P0155_MinStack();

        for (int i = 100; i >= 1; i--) stack.push(i);
        assertEquals(1, stack.getMin());

        for (int i = 1; i <= 100; i++) {
            assertEquals(i, stack.top());
            assertEquals(i, stack.getMin());
            stack.pop();
        }
    }
}
