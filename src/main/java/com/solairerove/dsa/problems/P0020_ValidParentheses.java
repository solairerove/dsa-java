package com.solairerove.dsa.problems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class P0020_ValidParentheses {

    // time O(n), space O(n)
    public static boolean isValid(String s) {
        Map<Character, Character> closedToOpen = new HashMap<>();
        closedToOpen.put(')', '(');
        closedToOpen.put('}', '{');
        closedToOpen.put(']', '[');
        Deque<Character> stack = new ArrayDeque<>();
        for (char br : s.toCharArray()) {
            if (closedToOpen.containsKey(br)) {
                if (stack.isEmpty() || stack.pop() != closedToOpen.get(br)) {
                    return false;
                }
            } else {
                stack.push(br);
            }
        }

        return stack.isEmpty();
    }
}
