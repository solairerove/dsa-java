package com.solairerove.dsa.problems;

import java.util.Stack;

public class P0071_SimplifyPath {

    // time O(n), space O(n)
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for (String p : path.split("/")) {
            if (p.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!p.isEmpty() && !p.equals(".")) {
                stack.push(p);
            }
        }

        return "/" + String.join("/", stack);
    }
}
