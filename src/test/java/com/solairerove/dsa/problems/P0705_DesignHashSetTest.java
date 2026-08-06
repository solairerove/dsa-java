package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("NewClassNamingConvention")
class P0705_DesignHashSetTest {

    @Test
    void followsLeetCodeExample() {
        P0705_DesignHashSet set = new P0705_DesignHashSet();

        set.add(1);
        set.add(2);
        assertTrue(set.contains(1));
        assertFalse(set.contains(3));

        set.add(2);
        assertTrue(set.contains(2));

        set.remove(2);
        assertFalse(set.contains(2));
    }

    @Test
    void emptySetContainsNothing() {
        P0705_DesignHashSet set = new P0705_DesignHashSet();

        assertFalse(set.contains(0));
        assertFalse(set.contains(1000000));
    }

    @Test
    void duplicateAddKeepsSingleEntry() {
        P0705_DesignHashSet set = new P0705_DesignHashSet();

        set.add(42);
        set.add(42);
        set.add(42);
        set.remove(42);

        assertFalse(set.contains(42));
    }

    @Test
    void removeMissingKeyIsNoOp() {
        P0705_DesignHashSet set = new P0705_DesignHashSet();

        set.add(5);
        set.remove(7);

        assertTrue(set.contains(5));
        assertFalse(set.contains(7));
    }

    @Test
    void handlesCollidingKeys() {
        P0705_DesignHashSet set = new P0705_DesignHashSet();

        set.add(3);
        set.add(10003);
        set.add(20003);

        assertTrue(set.contains(3));
        assertTrue(set.contains(10003));
        assertTrue(set.contains(20003));

        set.remove(10003);

        assertTrue(set.contains(3));
        assertFalse(set.contains(10003));
        assertTrue(set.contains(20003));
    }

    @Test
    void handlesBoundaryKeys() {
        P0705_DesignHashSet set = new P0705_DesignHashSet();

        set.add(0);
        set.add(1000000);

        assertTrue(set.contains(0));
        assertTrue(set.contains(1000000));

        set.remove(0);

        assertFalse(set.contains(0));
        assertTrue(set.contains(1000000));
    }

    @Test
    void handlesManyKeys() {
        P0705_DesignHashSet set = new P0705_DesignHashSet();

        for (int i = 0; i < 20000; i += 2) {
            set.add(i);
        }

        for (int i = 0; i < 20000; i++) {
            if (i % 2 == 0) {
                assertTrue(set.contains(i));
            } else {
                assertFalse(set.contains(i));
            }
        }
    }
}
