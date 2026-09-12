package com.solairerove.dsa.problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P0895_MaximumFrequencyStack {

    final Map<Integer, Integer> cnt;
    final List<Deque<Integer>> stacks;

    public P0895_MaximumFrequencyStack() {
        cnt = new HashMap<>();
        stacks = new ArrayList<>();
        stacks.add(new ArrayDeque<>());
    }

    // time O(1), space O(n)
    public void push(int val) {
        int valCnt = cnt.getOrDefault(val, 0) + 1;
        cnt.put(val, valCnt);
        if (valCnt == stacks.size()) {
            stacks.add(new ArrayDeque<>());
        }
        stacks.get(valCnt).push(val);
    }

    // time O(1), space O(1)
    public int pop() {
        int n = stacks.size();
        Deque<Integer> topStack = stacks.get(n - 1);
        int res = topStack.pop();
        cnt.merge(res, -1, Integer::sum);
        if (topStack.isEmpty()) {
            stacks.remove(n - 1);
        }

        return res;
    }
}
