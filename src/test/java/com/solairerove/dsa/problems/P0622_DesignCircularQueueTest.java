package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("NewClassNamingConvention")
class P0622_DesignCircularQueueTest {

    @Test
    void followsLeetCodeExample() {
        P0622_DesignCircularQueue queue = new P0622_DesignCircularQueue(3);

        assertTrue(queue.enQueue(1));
        assertTrue(queue.enQueue(2));
        assertTrue(queue.enQueue(3));
        assertFalse(queue.enQueue(4));
        assertEquals(3, queue.Rear());
        assertTrue(queue.isFull());
        assertTrue(queue.deQueue());
        assertTrue(queue.enQueue(4));
        assertEquals(4, queue.Rear());
    }

    @Test
    void emptyQueueReturnsDefaults() {
        P0622_DesignCircularQueue queue = new P0622_DesignCircularQueue(2);

        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());
        assertFalse(queue.deQueue());
        assertEquals(-1, queue.Front());
        assertEquals(-1, queue.Rear());
    }

    @Test
    void preservesFifoOrder() {
        P0622_DesignCircularQueue queue = new P0622_DesignCircularQueue(3);

        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(30);

        assertEquals(10, queue.Front());
        queue.deQueue();
        assertEquals(20, queue.Front());
        queue.deQueue();
        assertEquals(30, queue.Front());
        assertEquals(30, queue.Rear());
    }

    @Test
    void becomesEmptyAfterDequeueingAll() {
        P0622_DesignCircularQueue queue = new P0622_DesignCircularQueue(2);

        queue.enQueue(1);
        queue.enQueue(2);
        assertTrue(queue.deQueue());
        assertTrue(queue.deQueue());

        assertTrue(queue.isEmpty());
        assertFalse(queue.deQueue());
        assertEquals(-1, queue.Front());
        assertEquals(-1, queue.Rear());
    }

    @Test
    void reusableAfterBecomingEmpty() {
        P0622_DesignCircularQueue queue = new P0622_DesignCircularQueue(2);

        queue.enQueue(1);
        queue.deQueue();
        assertTrue(queue.enQueue(5));

        assertEquals(5, queue.Front());
        assertEquals(5, queue.Rear());
    }

    @Test
    void capacityOneFillsAndDrains() {
        P0622_DesignCircularQueue queue = new P0622_DesignCircularQueue(1);

        assertTrue(queue.enQueue(7));
        assertTrue(queue.isFull());
        assertFalse(queue.enQueue(8));
        assertEquals(7, queue.Front());
        assertEquals(7, queue.Rear());

        assertTrue(queue.deQueue());
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());
    }

    @Test
    void wrapsAroundRepeatedly() {
        P0622_DesignCircularQueue queue = new P0622_DesignCircularQueue(3);

        for (int i = 0; i < 10; i++) {
            assertTrue(queue.enQueue(i));
            if (i >= 2) {
                assertTrue(queue.isFull());
                assertEquals(i - 2, queue.Front());
                assertEquals(i, queue.Rear());
                assertTrue(queue.deQueue());
            }
        }

        assertEquals(8, queue.Front());
        assertEquals(9, queue.Rear());
    }

    @Test
    void storesZeroValues() {
        P0622_DesignCircularQueue queue = new P0622_DesignCircularQueue(2);

        queue.enQueue(0);
        queue.enQueue(0);

        assertEquals(0, queue.Front());
        assertEquals(0, queue.Rear());
        assertTrue(queue.isFull());
    }
}
