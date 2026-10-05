package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0146_LRUCacheTest {

    @Test
    void followsLeetCodeExample() {
        P0146_LRUCache cache = new P0146_LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(1, cache.get(1));
        cache.put(3, 3);
        assertEquals(-1, cache.get(2));
        cache.put(4, 4);
        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.get(3));
        assertEquals(4, cache.get(4));
    }

    @Test
    void missingKeyReturnsMinusOne() {
        P0146_LRUCache cache = new P0146_LRUCache(1);

        assertEquals(-1, cache.get(42));
    }

    @Test
    void capacityOneEvictsPrevious() {
        P0146_LRUCache cache = new P0146_LRUCache(1);

        cache.put(1, 10);
        cache.put(2, 20);
        assertEquals(-1, cache.get(1));
        assertEquals(20, cache.get(2));
    }

    @Test
    void putExistingKeyUpdatesValueWithoutEviction() {
        P0146_LRUCache cache = new P0146_LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(1, 100);
        assertEquals(100, cache.get(1));
        assertEquals(2, cache.get(2));
    }

    @Test
    void putExistingKeyRefreshesRecency() {
        P0146_LRUCache cache = new P0146_LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(1, 10);
        cache.put(3, 3);
        assertEquals(-1, cache.get(2));
        assertEquals(10, cache.get(1));
        assertEquals(3, cache.get(3));
    }

    @Test
    void getRefreshesRecency() {
        P0146_LRUCache cache = new P0146_LRUCache(3);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.get(1);
        cache.put(4, 4);
        assertEquals(-1, cache.get(2));
        assertEquals(1, cache.get(1));
        assertEquals(3, cache.get(3));
        assertEquals(4, cache.get(4));
    }

    @Test
    void missedGetDoesNotAffectEviction() {
        P0146_LRUCache cache = new P0146_LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(-1, cache.get(3));
        cache.put(3, 3);
        assertEquals(-1, cache.get(1));
        assertEquals(2, cache.get(2));
        assertEquals(3, cache.get(3));
    }

    @Test
    void zeroValuesAreStored() {
        P0146_LRUCache cache = new P0146_LRUCache(2);

        cache.put(0, 0);
        assertEquals(0, cache.get(0));
    }

    @Test
    void followsLeetCodeExampleLinkedHashMap() {
        P0146_LRUCache.LRUCacheLinkedHashMap cache = new P0146_LRUCache.LRUCacheLinkedHashMap(2);

        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(1, cache.get(1));
        cache.put(3, 3);
        assertEquals(-1, cache.get(2));
        cache.put(4, 4);
        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.get(3));
        assertEquals(4, cache.get(4));
    }

    @Test
    void missingKeyReturnsMinusOneLinkedHashMap() {
        P0146_LRUCache.LRUCacheLinkedHashMap cache = new P0146_LRUCache.LRUCacheLinkedHashMap(1);

        assertEquals(-1, cache.get(42));
    }

    @Test
    void capacityOneEvictsPreviousLinkedHashMap() {
        P0146_LRUCache.LRUCacheLinkedHashMap cache = new P0146_LRUCache.LRUCacheLinkedHashMap(1);

        cache.put(1, 10);
        cache.put(2, 20);
        assertEquals(-1, cache.get(1));
        assertEquals(20, cache.get(2));
    }

    @Test
    void putExistingKeyUpdatesValueWithoutEvictionLinkedHashMap() {
        P0146_LRUCache.LRUCacheLinkedHashMap cache = new P0146_LRUCache.LRUCacheLinkedHashMap(2);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(1, 100);
        assertEquals(100, cache.get(1));
        assertEquals(2, cache.get(2));
    }

    @Test
    void putExistingKeyRefreshesRecencyLinkedHashMap() {
        P0146_LRUCache.LRUCacheLinkedHashMap cache = new P0146_LRUCache.LRUCacheLinkedHashMap(2);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(1, 10);
        cache.put(3, 3);
        assertEquals(-1, cache.get(2));
        assertEquals(10, cache.get(1));
        assertEquals(3, cache.get(3));
    }

    @Test
    void getRefreshesRecencyLinkedHashMap() {
        P0146_LRUCache.LRUCacheLinkedHashMap cache = new P0146_LRUCache.LRUCacheLinkedHashMap(3);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.get(1);
        cache.put(4, 4);
        assertEquals(-1, cache.get(2));
        assertEquals(1, cache.get(1));
        assertEquals(3, cache.get(3));
        assertEquals(4, cache.get(4));
    }

    @Test
    void missedGetDoesNotAffectEvictionLinkedHashMap() {
        P0146_LRUCache.LRUCacheLinkedHashMap cache = new P0146_LRUCache.LRUCacheLinkedHashMap(2);

        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(-1, cache.get(3));
        cache.put(3, 3);
        assertEquals(-1, cache.get(1));
        assertEquals(2, cache.get(2));
        assertEquals(3, cache.get(3));
    }

    @Test
    void zeroValuesAreStoredLinkedHashMap() {
        P0146_LRUCache.LRUCacheLinkedHashMap cache = new P0146_LRUCache.LRUCacheLinkedHashMap(2);

        cache.put(0, 0);
        assertEquals(0, cache.get(0));
    }
}
