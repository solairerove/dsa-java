package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0460_LFUCacheTest {

    @Test
    void followsLeetCodeExample() {
        P0460_LFUCache cache = new P0460_LFUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(1, cache.get(1));
        cache.put(3, 3);
        assertEquals(-1, cache.get(2));
        assertEquals(3, cache.get(3));
        cache.put(4, 4);
        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.get(3));
        assertEquals(4, cache.get(4));
    }

    @Test
    void missingKeyReturnsMinusOne() {
        P0460_LFUCache cache = new P0460_LFUCache(1);

        assertEquals(-1, cache.get(42));
    }

    @Test
    void capacityOneEvictsPrevious() {
        P0460_LFUCache cache = new P0460_LFUCache(1);

        cache.put(1, 10);
        assertEquals(10, cache.get(1));
        cache.put(2, 20);
        assertEquals(-1, cache.get(1));
        assertEquals(20, cache.get(2));
    }

    @Test
    void evictsLeastFrequentlyUsed() {
        P0460_LFUCache cache = new P0460_LFUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.get(1);
        cache.get(2);
        cache.put(3, 3);
        assertEquals(-1, cache.get(2));
        assertEquals(1, cache.get(1));
        assertEquals(3, cache.get(3));
    }

    @Test
    void tieOnFrequencyEvictsLeastRecentlyUsed() {
        P0460_LFUCache cache = new P0460_LFUCache(3);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.get(2);
        cache.get(1);
        cache.get(3);
        cache.put(4, 4);
        assertEquals(-1, cache.get(2));
        assertEquals(1, cache.get(1));
        assertEquals(3, cache.get(3));
        assertEquals(4, cache.get(4));
    }

    @Test
    void putExistingKeyUpdatesValueAndFrequency() {
        P0460_LFUCache cache = new P0460_LFUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(1, 100);
        cache.put(3, 3);
        assertEquals(-1, cache.get(2));
        assertEquals(100, cache.get(1));
        assertEquals(3, cache.get(3));
    }

    @Test
    void newKeyResetsMinFrequency() {
        P0460_LFUCache cache = new P0460_LFUCache(2);

        cache.put(1, 1);
        cache.get(1);
        cache.get(1);
        cache.put(2, 2);
        cache.put(3, 3);
        assertEquals(-1, cache.get(2));
        assertEquals(1, cache.get(1));
        assertEquals(3, cache.get(3));
    }

    @Test
    void newKeyIsNotEvictedRightAfterInsert() {
        P0460_LFUCache cache = new P0460_LFUCache(1);

        cache.put(1, 1);
        cache.get(1);
        cache.get(1);
        cache.put(2, 2);
        assertEquals(2, cache.get(2));
        assertEquals(-1, cache.get(1));
    }

    @Test
    void minFrequencyAdvancesWhenBucketEmpties() {
        P0460_LFUCache cache = new P0460_LFUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.get(2);
        cache.get(2);
        cache.put(3, 3);
        assertEquals(-1, cache.get(1));
        cache.get(3);
        cache.get(3);
        cache.get(3);
        cache.put(4, 4);
        assertEquals(-1, cache.get(2));
        assertEquals(3, cache.get(3));
        assertEquals(4, cache.get(4));
    }

    @Test
    void missedGetDoesNotAffectEviction() {
        P0460_LFUCache cache = new P0460_LFUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(-1, cache.get(5));
        cache.put(3, 3);
        assertEquals(-1, cache.get(1));
        assertEquals(2, cache.get(2));
        assertEquals(3, cache.get(3));
    }
}
