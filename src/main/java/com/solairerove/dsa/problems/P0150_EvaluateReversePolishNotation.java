package com.solairerove.dsa.problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class P0150_EvaluateReversePolishNotation {

    // time O(n), space O(n)
    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String s : tokens) {
            switch (s) {
                case "+":
                    int top = stack.pop();
                    stack.push(stack.pop() + top);
                    break;
                case "*":
                    top = stack.pop();
                    stack.push(stack.pop() * top);
                    break;
                case "-":
                    top = stack.pop();
                    stack.push(stack.pop() - top);
                    break;
                case "/":
                    top = stack.pop();
                    stack.push(stack.pop() / top);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
                    break;
            }
        }

        return stack.peek();
    }
}
