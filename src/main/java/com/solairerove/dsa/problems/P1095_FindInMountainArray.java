package com.solairerove.dsa.problems;

import com.solairerove.dsa.common.MountainArray;

public class P1095_FindInMountainArray {

    // time O(log n), space O(1)
    public static int findInMountainArray(int target, MountainArray mountainArr) {
        int mountainIdx = findMountainIdx(mountainArr);
        int leftPart = bs(mountainArr, target, 0, mountainIdx - 1, false);
        if (leftPart == -1) {
            return bs(mountainArr, target, mountainIdx, mountainArr.length() - 1, true);
        }

        return leftPart;
    }

    private static int bs(MountainArray mountainArr, int target, int l, int r, boolean isRight) {
        while (l <= r) {
            int mid = (r + l) >>> 1;
            if (mountainArr.get(mid) == target) {
                return mid;
            } else if (!isRight && mountainArr.get(mid) < target) {
                l = mid + 1;
            } else if (isRight && mountainArr.get(mid) > target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }

    private static int findMountainIdx(MountainArray mountainArr) {
        int l = 0, r = mountainArr.length() - 1;
        if (isBefore(r, mountainArr)) {
            return mountainArr.get(r);
        }

        while (r - l > 1) {
            int mid = (r + l) >>> 1;
            if (isBefore(mid, mountainArr)) {
                l = mid;
            } else {
                r = mid;
            }
        }

        return l;
    }

    private static boolean isBefore(int i, MountainArray mountainArr) {
        return i == 0 || mountainArr.get(i) > mountainArr.get(i - 1);
    }
}
