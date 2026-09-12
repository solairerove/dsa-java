package com.solairerove.dsa.problems;

import java.util.ArrayDeque;
import java.util.Deque;
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

    private record Frame(StringBuilder prefix, int count) {
    }

    // time O(n * k), space O(n)
    public static String decodeStringDeque(String s) {
        Deque<Frame> dq = new ArrayDeque<>();
        StringBuilder cur = new StringBuilder();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                count = count * 10 + (ch - '0');
            } else if (ch == '[') {
                dq.push(new Frame(cur, count));
                cur = new StringBuilder();
                count = 0;
            } else if (ch == ']') {
                Frame frame = dq.pop();
                StringBuilder prefix = frame.prefix();
                prefix.repeat(String.valueOf(cur), Math.max(0, frame.count()));
                cur = prefix;
            } else {
                cur.append(ch);
            }
        }

        return cur.toString();
    }
}
