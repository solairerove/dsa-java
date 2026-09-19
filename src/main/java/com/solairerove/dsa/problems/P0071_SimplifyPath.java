package com.solairerove.dsa.problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class P0071_SimplifyPath {

    // time O(n), space O(n)
    public static String simplifyPath(String path) {
        Deque<String> dq = new ArrayDeque<>();
        for (String p : path.split("/")) {
            if (p.equals("..")) {
                if (!dq.isEmpty()) {
                    dq.pollLast();
                }
            } else if (!p.isEmpty() && !p.equals(".")) {
                dq.addLast(p);
            }
        }

        return "/" + String.join("/", dq);
    }
}
