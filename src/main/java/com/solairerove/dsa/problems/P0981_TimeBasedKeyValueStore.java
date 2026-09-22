package com.solairerove.dsa.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P0981_TimeBasedKeyValueStore {

    private record Pair(int timestamp, String value) {
    }

    private final Map<String, List<Pair>> storage;

    public P0981_TimeBasedKeyValueStore() {
        storage = new HashMap<>();
    }

    // time O(1) amortized, space O(n)
    // LeetCode guarantees set is called with strictly increasing timestamps per key, so the list is
    // already sorted by timestamp and needs no insertion search. Without that guarantee the binary
    // search in get would be wrong.
    public void set(String key, String value, int timestamp) {
        storage.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(timestamp, value));
    }

    // time O(log n), space O(1)
    // the loop pushes l past every timestamp <= the target, so on exit r == l - 1: the last index
    // holding a timestamp <= the target, or -1 when even the earliest set came later.
    public String get(String key, int timestamp) {
        List<Pair> pairs = storage.get(key);
        if (pairs == null) {
            return "";
        }

        int l = 0, r = pairs.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (pairs.get(mid).timestamp() <= timestamp) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return r >= 0 ? pairs.get(r).value() : "";
    }
}
