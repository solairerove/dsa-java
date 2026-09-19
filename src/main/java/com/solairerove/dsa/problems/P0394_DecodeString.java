package com.solairerove.dsa.problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class P0394_DecodeString {

    // time O(n * k), space O(n)
    public static String decodeString(String s) {
        Deque<String> dq = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (ch == ']') {
                StringBuilder inner = new StringBuilder();
                while (!dq.isEmpty() && Character.isLetter(dq.peekLast().charAt(0))) {
                    inner.insert(0, dq.pollLast());
                }
                dq.pollLast(); // [

                StringBuilder count = new StringBuilder();
                while (!dq.isEmpty() && Character.isDigit(dq.peekLast().charAt(0))) {
                    count.insert(0, dq.pollLast());
                }

                String substring = inner.toString().repeat(Integer.parseInt(count.toString()));
                dq.offerLast(substring);
            } else {
                dq.offerLast(String.valueOf(ch));
            }
        }

        return String.join("", dq);
    }
}
