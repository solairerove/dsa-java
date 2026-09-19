package com.solairerove.dsa.problems;

import java.util.Stack;

public class P0394_DecodeString {

    // time O(n * k), space O(n)
    public static String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for (Character ch : s.toCharArray()) {
            if (ch == ']') {
                StringBuilder inner = new StringBuilder();
                while (!stack.isEmpty() && Character.isLetter(stack.peek().toCharArray()[0])) {
                    inner.insert(0, stack.pop());
                }
                stack.pop();

                StringBuilder count = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek().toCharArray()[0])) {
                    count.insert(0, stack.pop());
                }

                String substring = inner.toString().repeat(Integer.parseInt(count.toString()));
                stack.push(substring);
            } else {
                stack.push(String.valueOf(ch));
            }
        }

        return String.join("", stack);
    }
}
