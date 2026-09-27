package com.solairerove.dsa.problems;

import com.solairerove.dsa.common.MountainArray;

public class P1095_FindInMountainArray {

    // time O(log n), space O(1)
    public static int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int peakIdx = findPeak(mountainArr, n);
        int leftRes = binarySearch(mountainArr, target, 0, peakIdx - 1, true);
        if (leftRes != -1) {
            return leftRes;
        }

        return binarySearch(mountainArr, target, peakIdx, n - 1, false);
    }

    private static int binarySearch(MountainArray mountainArr, int target, int l, int r, boolean isAsc) {
        while (l <= r) {
            int mid = (r + l) >>> 1;
            int guess = mountainArr.get(mid);
            if (guess == target) {
                return mid;
            } else if (isAsc == (guess < target)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }

    private static int findPeak(MountainArray mountainArr, int n) {
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (r + l) >>> 1;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}
