package com.solairerove.dsa.problems;

public class P0069_SqrtX {

    // time O(log x), space O(1)
    public static int mySqrt(int x) {
        int l = 0, r = x;
        int res = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            long guess = (long) mid * mid;
            if (guess == x) {
                return mid;
            } else if (guess < x) {
                l = mid + 1;
                res = mid;
            } else {
                r = mid - 1;
            }
        }

        return res;
    }

    // time O(log x), space O(1)
    public static int mySqrtNewton(int x) {
        long r = x;
        while (r * r > x) {
            r = (r + x / r) >> 1;
        }

        return (int) r;
    }
}
