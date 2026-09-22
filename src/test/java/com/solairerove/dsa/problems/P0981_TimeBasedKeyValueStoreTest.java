package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0981_TimeBasedKeyValueStoreTest {

    @Test
    void followsLeetCodeExample() {
        P0981_TimeBasedKeyValueStore map = new P0981_TimeBasedKeyValueStore();

        map.set("foo", "bar", 1);
        assertEquals("bar", map.get("foo", 1));
        assertEquals("bar", map.get("foo", 3));
        map.set("foo", "bar2", 4);
        assertEquals("bar2", map.get("foo", 4));
        assertEquals("bar2", map.get("foo", 5));
    }

    @Test
    void missingKeyReturnsEmpty() {
        P0981_TimeBasedKeyValueStore map = new P0981_TimeBasedKeyValueStore();

        assertEquals("", map.get("foo", 1));
    }

    @Test
    void timestampBeforeFirstSetReturnsEmpty() {
        P0981_TimeBasedKeyValueStore map = new P0981_TimeBasedKeyValueStore();

        map.set("foo", "bar", 5);
        assertEquals("", map.get("foo", 1));
        assertEquals("", map.get("foo", 4));
        assertEquals("bar", map.get("foo", 5));
    }

    @Test
    void exactTimestampHits() {
        P0981_TimeBasedKeyValueStore map = new P0981_TimeBasedKeyValueStore();

        map.set("k", "v1", 10);
        map.set("k", "v2", 20);
        map.set("k", "v3", 30);
        assertEquals("v1", map.get("k", 10));
        assertEquals("v2", map.get("k", 20));
        assertEquals("v3", map.get("k", 30));
    }

    @Test
    void betweenTimestampsPicksPrevious() {
        P0981_TimeBasedKeyValueStore map = new P0981_TimeBasedKeyValueStore();

        map.set("k", "v1", 10);
        map.set("k", "v2", 20);
        map.set("k", "v3", 30);
        assertEquals("v1", map.get("k", 15));
        assertEquals("v2", map.get("k", 29));
        assertEquals("v3", map.get("k", 1000));
    }

    @Test
    void keysAreIndependent() {
        P0981_TimeBasedKeyValueStore map = new P0981_TimeBasedKeyValueStore();

        map.set("a", "a1", 1);
        map.set("b", "b1", 2);
        map.set("a", "a2", 3);
        assertEquals("a1", map.get("a", 2));
        assertEquals("a2", map.get("a", 3));
        assertEquals("", map.get("b", 1));
        assertEquals("b1", map.get("b", 5));
    }

    @Test
    void sameTimestampOverwrittenByLatestSet() {
        P0981_TimeBasedKeyValueStore map = new P0981_TimeBasedKeyValueStore();

        map.set("k", "v1", 1);
        map.set("k", "v2", 1);
        assertEquals("v2", map.get("k", 1));
    }

    @Test
    void singleEntry() {
        P0981_TimeBasedKeyValueStore map = new P0981_TimeBasedKeyValueStore();

        map.set("k", "v", 7);
        assertEquals("v", map.get("k", 7));
        assertEquals("v", map.get("k", 8));
        assertEquals("", map.get("k", 6));
    }

    @Test
    void emptyStringValueIsStored() {
        P0981_TimeBasedKeyValueStore map = new P0981_TimeBasedKeyValueStore();

        map.set("k", "", 1);
        assertEquals("", map.get("k", 1));
    }

    @Test
    void largeTimestampsBeyondIntegerCache() {
        P0981_TimeBasedKeyValueStore map = new P0981_TimeBasedKeyValueStore();

        map.set("k", "v1", 1000);
        map.set("k", "v2", 100000);
        map.set("k", "v3", Integer.MAX_VALUE);
        assertEquals("v1", map.get("k", 1000));
        assertEquals("v1", map.get("k", 99999));
        assertEquals("v2", map.get("k", 100000));
        assertEquals("v3", map.get("k", Integer.MAX_VALUE));
    }

    @Test
    void manyEntriesBinarySearchStaysCorrect() {
        P0981_TimeBasedKeyValueStore map = new P0981_TimeBasedKeyValueStore();

        for (int i = 1; i <= 1000; i++) {
            map.set("k", "v" + i, i * 2);
        }

        for (int i = 1; i <= 1000; i++) {
            assertEquals("v" + i, map.get("k", i * 2));
            assertEquals("v" + i, map.get("k", i * 2 + 1));
        }
        assertEquals("", map.get("k", 1));
    }
}
