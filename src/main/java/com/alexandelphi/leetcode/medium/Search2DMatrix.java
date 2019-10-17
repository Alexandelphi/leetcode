package com.alexandelphi.leetcode.medium;

public class Search2DMatrix {

  // my straightforward solution with using binary search
  // could I do better? I think yes, and I'll add another solution later
  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Search a 2D Matrix.
  // Memory Usage: 41.6 MB, less than 6.06% of Java online submissions for Search a 2D Matrix.
  // https://leetcode.com/problems/search-a-2d-matrix

  public boolean searchMatrix(int[][] matrix, int target) {
    for (int[] arr : matrix) {
      if (isTargetFoundWithBinarySearch(arr, target)) {
        return true;
      }
    }
    return false;
  }

  private boolean isTargetFoundWithBinarySearch(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (arr[mid] == target) {
        return true;
      } else if (arr[mid] < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return false;
  }
}
