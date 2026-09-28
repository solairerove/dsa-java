package com.solairerove.dsa.problems;

public class P0852_PeakIndexInAMountainArray {

    // time O(log n), space O(1)
    public static int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = (r + l) >>> 1;
            if (arr[mid] < arr[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}
