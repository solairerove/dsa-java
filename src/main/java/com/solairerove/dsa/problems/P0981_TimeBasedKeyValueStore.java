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
    // half-open [l, r) upper bound, same shape as P0704_BinarySearch.searchUpperBound: on exit l is
    // the first index holding a timestamp > the target, so the answer sits one step left. r starts
    // at size() because the bound may land past the last element, and the step is r = mid, not
    // mid - 1, because mid itself is still a candidate for that bound. l == 0 means even the
    // earliest set came later.
    public String get(String key, int timestamp) {
        List<Pair> pairs = storage.get(key);
        if (pairs == null) {
            return "";
        }

        int l = 0, r = pairs.size();
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (pairs.get(mid).timestamp() > timestamp) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l > 0 ? pairs.get(l - 1).value() : "";
    }
}
