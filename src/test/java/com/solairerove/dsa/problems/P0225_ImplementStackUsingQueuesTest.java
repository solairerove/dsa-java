package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("NewClassNamingConvention")
class P0225_ImplementStackUsingQueuesTest {

    @Test
    void followsLeetCodeExample() {
        P0225_ImplementStackUsingQueues stack = new P0225_ImplementStackUsingQueues();

        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.top());
        assertEquals(2, stack.pop());
        assertFalse(stack.empty());
    }

    @Test
    void newStackIsEmpty() {
        assertTrue(new P0225_ImplementStackUsingQueues().empty());
    }

    @Test
    void singlePushPop() {
        P0225_ImplementStackUsingQueues stack = new P0225_ImplementStackUsingQueues();

        stack.push(42);
        assertFalse(stack.empty());
        assertEquals(42, stack.pop());
        assertTrue(stack.empty());
    }

    @Test
    void lifoOrder() {
        P0225_ImplementStackUsingQueues stack = new P0225_ImplementStackUsingQueues();

        for (int i = 1; i <= 5; i++) stack.push(i);
        for (int i = 5; i >= 1; i--) assertEquals(i, stack.pop());

        assertTrue(stack.empty());
    }

    @Test
    void topDoesNotRemove() {
        P0225_ImplementStackUsingQueues stack = new P0225_ImplementStackUsingQueues();

        stack.push(7);
        assertEquals(7, stack.top());
        assertEquals(7, stack.top());
        assertEquals(7, stack.pop());
        assertTrue(stack.empty());
    }

    @Test
    void interleavedPushPop() {
        P0225_ImplementStackUsingQueues stack = new P0225_ImplementStackUsingQueues();

        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());
        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(1, stack.pop());
        assertTrue(stack.empty());
    }

    @Test
    void reusableAfterEmptying() {
        P0225_ImplementStackUsingQueues stack = new P0225_ImplementStackUsingQueues();

        stack.push(1);
        stack.pop();
        assertTrue(stack.empty());

        stack.push(2);
        assertEquals(2, stack.top());
        assertFalse(stack.empty());
    }

    @Test
    void duplicateValues() {
        P0225_ImplementStackUsingQueues stack = new P0225_ImplementStackUsingQueues();

        stack.push(9);
        stack.push(9);
        assertEquals(9, stack.pop());
        assertEquals(9, stack.pop());
        assertTrue(stack.empty());
    }

    @Test
    void manyElements() {
        P0225_ImplementStackUsingQueues stack = new P0225_ImplementStackUsingQueues();

        for (int i = 0; i < 100; i++) stack.push(i);
        assertEquals(99, stack.top());
        for (int i = 99; i >= 0; i--) assertEquals(i, stack.pop());

        assertTrue(stack.empty());
    }
}
