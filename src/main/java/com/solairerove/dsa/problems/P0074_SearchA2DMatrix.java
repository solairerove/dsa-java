package com.solairerove.dsa.problems;

public class P0074_SearchA2DMatrix {

    // time O(log m + log n), space O(1)
    public static boolean searchMatrix(int[][] matrix, int target) {
        int l = 0, r = matrix.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (matrix[mid][0] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        int row = l > 0 ? l - 1 : l;
        return binarySearch(matrix[row], target);
    }

    private static boolean binarySearch(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int guess = arr[mid];
            if (guess == target) {
                return true;
            } else if (guess < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return false;
    }

    // time O(log(m * n)), space O(1)
    // treat the matrix as one flat sorted array of m * n values
    public static boolean searchMatrixFlat(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int l = 0, r = rows * cols - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int row = mid / cols, col = mid % cols;
            int guess = matrix[row][col];
            if (guess == target) {
                return true;
            } else if (guess < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return false;
    }
}
