package com.solairerove.dsa.common;

public class MountainArray {
    private final int[] arr;
    private int calls;

    public MountainArray(int[] arr) {
        this.arr = arr;
    }

    public int get(int index) {
        calls++;
        return arr[index];
    }

    public int length() {
        return arr.length;
    }

    public int calls() {
        return calls;
    }
}
