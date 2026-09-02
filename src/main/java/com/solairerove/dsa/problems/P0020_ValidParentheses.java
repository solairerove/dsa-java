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

    // time O(n), space O(n)
    public static boolean isValidArray(String s) {
        char[] stack = new char[s.length()];
        int top = 0;
        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '(': stack[top++] = ')'; break;
                case '[': stack[top++] = ']'; break;
                case '{': stack[top++] = '}'; break;
                default:
                    if (top == 0 || stack[--top] != ch) return false;
                    break;
            }
        }

        return top == 0;
    }
}
