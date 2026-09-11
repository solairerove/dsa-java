package com.solairerove.dsa.problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class P0682_BaseballGame {

    // time O(n), space O(n)
    public static int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String op : operations) {
            switch (op) {
                case "+":
                    int top = stack.pop();
                    int newTop = top + stack.peek();
                    stack.push(top);
                    stack.push(newTop);
                    break;
                case "D":
                    stack.push(stack.peek() * 2);
                    break;
                case "C":
                    stack.pop();
                    break;
                default:
                    stack.push(Integer.parseInt(op));
                    break;
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) sum += stack.pop();

        return sum;
    }

    // time O(n), space O(n)
    public static int calPointsArray(String[] operations) {
        int[] stack = new int[operations.length];
        int top = -1;
        for (String op : operations) {
            switch (op) {
                case "+" -> {
                    int sum = stack[top] + stack[top - 1];
                    stack[++top] = sum;
                }
                case "D" -> {
                    int doubled = stack[top] * 2;
                    stack[++top] = doubled;
                }
                case "C" -> top--;
                default -> stack[++top] = Integer.parseInt(op);
            }
        }

        int sum = 0;
        for (int i = 0; i <= top; i++) sum += stack[i];

        return sum;
    }
}
