package com.solairerove.dsa.common;

public abstract class GuessGame {
    private final int picked;
    private int calls;

    protected GuessGame(int picked) {
        this.picked = picked;
    }

    // -1 if num is higher than the picked number, 1 if num is lower, otherwise 0
    protected int guess(int num) {
        calls++;
        return Integer.compare(picked, num);
    }

    public int calls() {
        return calls;
    }
}
