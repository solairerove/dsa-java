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

    // time O(n), space O(n)
    public static int evalRPNArray(String[] tokens) {
        int[] stack = new int[tokens.length];
        int top = -1;
        for (String op : tokens) {
            switch (op) {
                case "+", "-", "*", "/" -> {
                    int b = stack[top--];
                    int a = stack[top--];
                    stack[++top] = switch (op) {
                        case "+" -> a + b;
                        case "-" -> a - b;
                        case "*" -> a * b;
                        default -> a / b;
                    };
                }
                default -> stack[++top] = Integer.parseInt(op);
            }
        }

        return stack[0];
    }
}
