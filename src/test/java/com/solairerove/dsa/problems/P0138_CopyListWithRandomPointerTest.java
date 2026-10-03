package com.solairerove.dsa.problems;

import com.solairerove.dsa.problems.P0138_CopyListWithRandomPointer.Node;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.UnaryOperator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

@SuppressWarnings("NewClassNamingConvention")
class P0138_CopyListWithRandomPointerTest {

    // each pair is {val, randomIndex}, randomIndex null means no random pointer
    private static Node build(Integer[][] pairs) {
        List<Node> nodes = new ArrayList<>();
        for (Integer[] pair : pairs) {
            nodes.add(new Node(pair[0]));
        }
        for (int i = 0; i < nodes.size(); i++) {
            if (i + 1 < nodes.size()) {
                nodes.get(i).next = nodes.get(i + 1);
            }
            Integer randomIndex = pairs[i][1];
            if (randomIndex != null) {
                nodes.get(i).random = nodes.get(randomIndex);
            }
        }
        return nodes.isEmpty() ? null : nodes.getFirst();
    }

    private static List<List<Integer>> serialize(Node head) {
        Map<Node, Integer> index = new IdentityHashMap<>();
        int i = 0;
        for (Node curr = head; curr != null; curr = curr.next) {
            index.put(curr, i++);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (Node curr = head; curr != null; curr = curr.next) {
            List<Integer> pair = new ArrayList<>();
            pair.add(curr.val);
            pair.add(curr.random == null ? null : index.get(curr.random));
            result.add(pair);
        }
        return result;
    }

    private static void assertDeepCopy(Integer[][] pairs, UnaryOperator<Node> copier) {
        Node original = build(pairs);
        List<List<Integer>> expected = serialize(original);

        Map<Node, Boolean> originalNodes = new IdentityHashMap<>();
        for (Node curr = original; curr != null; curr = curr.next) {
            originalNodes.put(curr, true);
        }

        Node copy = copier.apply(original);

        assertEquals(expected, serialize(copy));
        assertEquals(expected, serialize(original));
        for (Node curr = copy; curr != null; curr = curr.next) {
            assertFalse(originalNodes.containsKey(curr));
            if (curr.random != null) {
                assertFalse(originalNodes.containsKey(curr.random));
            }
        }
    }

    private static final Integer[][] EXAMPLE_1 = {{7, null}, {13, 0}, {11, 4}, {10, 2}, {1, 0}};
    private static final Integer[][] EXAMPLE_2 = {{1, 1}, {2, 1}};
    private static final Integer[][] EXAMPLE_3 = {{3, null}, {3, 0}, {3, null}};
    private static final Integer[][] SINGLE_SELF_RANDOM = {{5, 0}};
    private static final Integer[][] NO_RANDOMS = {{1, null}, {2, null}, {3, null}};

    @Test
    void example1() {
        assertDeepCopy(EXAMPLE_1, P0138_CopyListWithRandomPointer::copyRandomList);
    }

    @Test
    void example2() {
        assertDeepCopy(EXAMPLE_2, P0138_CopyListWithRandomPointer::copyRandomList);
    }

    @Test
    void example3DuplicateValues() {
        assertDeepCopy(EXAMPLE_3, P0138_CopyListWithRandomPointer::copyRandomList);
    }

    @Test
    void singleNodeRandomToSelf() {
        assertDeepCopy(SINGLE_SELF_RANDOM, P0138_CopyListWithRandomPointer::copyRandomList);
    }

    @Test
    void noRandomPointers() {
        assertDeepCopy(NO_RANDOMS, P0138_CopyListWithRandomPointer::copyRandomList);
    }

    @Test
    void emptyList() {
        assertNull(P0138_CopyListWithRandomPointer.copyRandomList(null));
    }

    @Test
    void example1Interleave() {
        assertDeepCopy(EXAMPLE_1, P0138_CopyListWithRandomPointer::copyRandomListInterleave);
    }

    @Test
    void example2Interleave() {
        assertDeepCopy(EXAMPLE_2, P0138_CopyListWithRandomPointer::copyRandomListInterleave);
    }

    @Test
    void example3DuplicateValuesInterleave() {
        assertDeepCopy(EXAMPLE_3, P0138_CopyListWithRandomPointer::copyRandomListInterleave);
    }

    @Test
    void singleNodeRandomToSelfInterleave() {
        assertDeepCopy(SINGLE_SELF_RANDOM, P0138_CopyListWithRandomPointer::copyRandomListInterleave);
    }

    @Test
    void noRandomPointersInterleave() {
        assertDeepCopy(NO_RANDOMS, P0138_CopyListWithRandomPointer::copyRandomListInterleave);
    }

    @Test
    void emptyListInterleave() {
        assertNull(P0138_CopyListWithRandomPointer.copyRandomListInterleave(null));
    }
}
