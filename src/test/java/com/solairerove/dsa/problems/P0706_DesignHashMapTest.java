package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0706_DesignHashMapTest {

    @Test
    void followsLeetCodeExample() {
        P0706_DesignHashMap map = new P0706_DesignHashMap();

        map.put(1, 1);
        map.put(2, 2);
        assertEquals(1, map.get(1));
        assertEquals(-1, map.get(3));

        map.put(2, 1);
        assertEquals(1, map.get(2));

        map.remove(2);
        assertEquals(-1, map.get(2));
    }

    @Test
    void emptyMapReturnsMinusOne() {
        P0706_DesignHashMap map = new P0706_DesignHashMap();

        assertEquals(-1, map.get(0));
        assertEquals(-1, map.get(1000000));
    }

    @Test
    void putOverwritesExistingValue() {
        P0706_DesignHashMap map = new P0706_DesignHashMap();

        map.put(7, 10);
        map.put(7, 20);

        assertEquals(20, map.get(7));

        map.remove(7);

        assertEquals(-1, map.get(7));
    }

    @Test
    void removeMissingKeyIsNoOp() {
        P0706_DesignHashMap map = new P0706_DesignHashMap();

        map.put(5, 50);
        map.remove(9);

        assertEquals(50, map.get(5));
        assertEquals(-1, map.get(9));
    }

    @Test
    void handlesCollidingKeys() {
        P0706_DesignHashMap map = new P0706_DesignHashMap();

        map.put(3, 30);
        map.put(1003, 1030);
        map.put(2003, 2030);

        assertEquals(30, map.get(3));
        assertEquals(1030, map.get(1003));
        assertEquals(2030, map.get(2003));

        map.remove(1003);

        assertEquals(30, map.get(3));
        assertEquals(-1, map.get(1003));
        assertEquals(2030, map.get(2003));
    }

    @Test
    void handlesBoundaryKeysAndValues() {
        P0706_DesignHashMap map = new P0706_DesignHashMap();

        map.put(0, 0);
        map.put(1000000, 1000000);

        assertEquals(0, map.get(0));
        assertEquals(1000000, map.get(1000000));

        map.remove(0);

        assertEquals(-1, map.get(0));
        assertEquals(1000000, map.get(1000000));
    }

    @Test
    void handlesManyKeys() {
        P0706_DesignHashMap map = new P0706_DesignHashMap();

        for (int i = 0; i < 5000; i += 2) {
            map.put(i, i * 3);
        }

        for (int i = 0; i < 5000; i++) {
            assertEquals(i % 2 == 0 ? i * 3 : -1, map.get(i));
        }
    }
}
