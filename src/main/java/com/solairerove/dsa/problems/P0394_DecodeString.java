package com.solairerove.dsa.problems;

import java.util.Stack;

public class P0394_DecodeString {

    // time O(n * k), space O(n)
    public static String decodeString(String s) {
        Stack<String> dq = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                StringBuilder inner = new StringBuilder();
                while (!dq.isEmpty() && !dq.peek().equals("[")) {
                    inner.insert(0, dq.pop());
                }
                dq.pop();

                StringBuilder k = new StringBuilder();
                while (!dq.isEmpty() && Character.isDigit(dq.peek().charAt(0))) {
                    k.insert(0, dq.pop());
                }
                int count = Integer.parseInt(k.toString());
                String repeatedStr = inner.toString().repeat(count);

                dq.push(repeatedStr);
            } else {
                dq.push(String.valueOf(s.charAt(i)));
            }
        }

        StringBuilder res = new StringBuilder();
        while (!dq.isEmpty()) {
            res.insert(0, dq.pop());
        }

        return res.toString();
    }

    // time O(n * k), space O(n)
    public static String decodeStringTwoStacks(String s) {
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        StringBuilder curr = new StringBuilder();
        int k = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                stringStack.push(curr.toString());
                countStack.push(k);
                curr = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                String temp = curr.toString();
                curr = new StringBuilder(stringStack.pop());
                int count = countStack.pop();
                curr.repeat(temp, Math.max(0, count));
            } else {
                curr.append(ch);
            }
        }

        return curr.toString();
    }
}
