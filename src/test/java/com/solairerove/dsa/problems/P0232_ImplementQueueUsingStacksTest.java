package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("NewClassNamingConvention")
class P0232_ImplementQueueUsingStacksTest {

    @Test
    void followsLeetCodeExample() {
        P0232_ImplementQueueUsingStacks queue = new P0232_ImplementQueueUsingStacks();

        queue.push(1);
        queue.push(2);
        assertEquals(1, queue.peek());
        assertEquals(1, queue.pop());
        assertFalse(queue.empty());
    }

    @Test
    void newQueueIsEmpty() {
        assertTrue(new P0232_ImplementQueueUsingStacks().empty());
    }

    @Test
    void singlePushPop() {
        P0232_ImplementQueueUsingStacks queue = new P0232_ImplementQueueUsingStacks();

        queue.push(42);
        assertFalse(queue.empty());
        assertEquals(42, queue.pop());
        assertTrue(queue.empty());
    }

    @Test
    void fifoOrder() {
        P0232_ImplementQueueUsingStacks queue = new P0232_ImplementQueueUsingStacks();

        for (int i = 1; i <= 5; i++) queue.push(i);
        for (int i = 1; i <= 5; i++) assertEquals(i, queue.pop());

        assertTrue(queue.empty());
    }

    @Test
    void peekDoesNotRemove() {
        P0232_ImplementQueueUsingStacks queue = new P0232_ImplementQueueUsingStacks();

        queue.push(7);
        assertEquals(7, queue.peek());
        assertEquals(7, queue.peek());
        assertEquals(7, queue.pop());
        assertTrue(queue.empty());
    }

    @Test
    void interleavedPushPop() {
        P0232_ImplementQueueUsingStacks queue = new P0232_ImplementQueueUsingStacks();

        queue.push(1);
        queue.push(2);
        assertEquals(1, queue.pop());
        queue.push(3);
        assertEquals(2, queue.pop());
        assertEquals(3, queue.pop());
        assertTrue(queue.empty());
    }

    @Test
    void pushWhileOutputStackNonEmpty() {
        P0232_ImplementQueueUsingStacks queue = new P0232_ImplementQueueUsingStacks();

        queue.push(1);
        queue.push(2);
        assertEquals(1, queue.pop());
        queue.push(3);
        queue.push(4);
        assertEquals(2, queue.peek());
        assertEquals(2, queue.pop());
        assertEquals(3, queue.pop());
        assertEquals(4, queue.pop());
        assertTrue(queue.empty());
    }

    @Test
    void reusableAfterEmptying() {
        P0232_ImplementQueueUsingStacks queue = new P0232_ImplementQueueUsingStacks();

        queue.push(1);
        queue.pop();
        assertTrue(queue.empty());

        queue.push(2);
        assertEquals(2, queue.peek());
        assertFalse(queue.empty());
    }

    @Test
    void duplicateValues() {
        P0232_ImplementQueueUsingStacks queue = new P0232_ImplementQueueUsingStacks();

        queue.push(9);
        queue.push(9);
        assertEquals(9, queue.pop());
        assertEquals(9, queue.pop());
        assertTrue(queue.empty());
    }

    @Test
    void manyElements() {
        P0232_ImplementQueueUsingStacks queue = new P0232_ImplementQueueUsingStacks();

        for (int i = 0; i < 100; i++) queue.push(i);
        assertEquals(0, queue.peek());
        for (int i = 0; i < 100; i++) assertEquals(i, queue.pop());

        assertTrue(queue.empty());
    }

    @Test
    void negativeValues() {
        P0232_ImplementQueueUsingStacks queue = new P0232_ImplementQueueUsingStacks();

        queue.push(-1);
        queue.push(-2);
        assertEquals(-1, queue.pop());
        assertEquals(-2, queue.pop());
        assertTrue(queue.empty());
    }
}
