package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0895_MaximumFrequencyStackTest {

    @Test
    void followsLeetCodeExample() {
        P0895_MaximumFrequencyStack stack = new P0895_MaximumFrequencyStack();

        stack.push(5);
        stack.push(7);
        stack.push(5);
        stack.push(7);
        stack.push(4);
        stack.push(5);

        assertEquals(5, stack.pop());
        assertEquals(7, stack.pop());
        assertEquals(5, stack.pop());
        assertEquals(4, stack.pop());
    }

    @Test
    void singleElement() {
        P0895_MaximumFrequencyStack stack = new P0895_MaximumFrequencyStack();

        stack.push(1);
        assertEquals(1, stack.pop());
    }

    @Test
    void allDistinctPopsInStackOrder() {
        P0895_MaximumFrequencyStack stack = new P0895_MaximumFrequencyStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    void allSameValue() {
        P0895_MaximumFrequencyStack stack = new P0895_MaximumFrequencyStack();

        stack.push(9);
        stack.push(9);
        stack.push(9);

        assertEquals(9, stack.pop());
        assertEquals(9, stack.pop());
        assertEquals(9, stack.pop());
    }

    @Test
    void frequencyBeatsRecency() {
        P0895_MaximumFrequencyStack stack = new P0895_MaximumFrequencyStack();

        stack.push(1);
        stack.push(1);
        stack.push(2);

        assertEquals(1, stack.pop());
    }

    @Test
    void tieBreaksByMostRecent() {
        P0895_MaximumFrequencyStack stack = new P0895_MaximumFrequencyStack();

        stack.push(1);
        stack.push(2);
        stack.push(1);
        stack.push(2);

        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    void pushAfterPopRestoresFrequency() {
        P0895_MaximumFrequencyStack stack = new P0895_MaximumFrequencyStack();

        stack.push(1);
        stack.push(1);
        stack.push(2);

        assertEquals(1, stack.pop());
        stack.push(2);
        assertEquals(2, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    void interleavedPushAndPop() {
        P0895_MaximumFrequencyStack stack = new P0895_MaximumFrequencyStack();

        stack.push(4);
        assertEquals(4, stack.pop());
        stack.push(4);
        stack.push(5);
        stack.push(4);
        assertEquals(4, stack.pop());
        assertEquals(5, stack.pop());
        assertEquals(4, stack.pop());
    }

    @Test
    void negativeValues() {
        P0895_MaximumFrequencyStack stack = new P0895_MaximumFrequencyStack();

        stack.push(-1);
        stack.push(-2);
        stack.push(-1);

        assertEquals(-1, stack.pop());
        assertEquals(-2, stack.pop());
        assertEquals(-1, stack.pop());
    }

    @Test
    void largeValuesOutsideIntegerCache() {
        P0895_MaximumFrequencyStack stack = new P0895_MaximumFrequencyStack();

        stack.push(512);
        stack.push(-1024);
        stack.push(512);

        assertEquals(512, stack.pop());
        assertEquals(-1024, stack.pop());
        assertEquals(512, stack.pop());
    }

    @Test
    void drainsFullyAndRefills() {
        P0895_MaximumFrequencyStack stack = new P0895_MaximumFrequencyStack();

        stack.push(1);
        stack.push(1);
        assertEquals(1, stack.pop());
        assertEquals(1, stack.pop());

        stack.push(2);
        stack.push(3);
        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
    }

    @Test
    void matchesBruteForceOnRandomOperations() {
        P0895_MaximumFrequencyStack stack = new P0895_MaximumFrequencyStack();
        List<Integer> log = new ArrayList<>();
        java.util.Random random = new java.util.Random(42);

        for (int i = 0; i < 2000; i++) {
            if (log.isEmpty() || random.nextInt(100) < 60) {
                int val = random.nextInt(10);
                stack.push(val);
                log.add(val);
            } else {
                assertEquals(bruteForcePop(log), stack.pop());
            }
        }
    }

    private static int bruteForcePop(List<Integer> log) {
        java.util.Map<Integer, Integer> freq = new java.util.HashMap<>();
        for (int val : log) {
            freq.merge(val, 1, Integer::sum);
        }

        int maxFreq = freq.values().stream().max(Integer::compare).orElseThrow();
        for (int i = log.size() - 1; i >= 0; i--) {
            if (freq.get(log.get(i)) == maxFreq) {
                return log.remove(i);
            }
        }

        throw new IllegalStateException("unreachable");
    }
}
