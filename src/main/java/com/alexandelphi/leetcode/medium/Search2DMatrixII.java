package com.alexandelphi.leetcode.medium;

//Runtime: 6 ms, faster than 30.64% of Java online submissions for Search a 2D Matrix II.
//Memory Usage: 42.4 MB, less than 100.00% of Java online submissions for Search a 2D Matrix II.

// my straightforward solution with BinarySearch
// Can I do better then that? I guess yes, but I need to think a little
// for m x n matrix, O(m * log(n)) time and O(1) space complexity
public class Search2DMatrixII {
  public boolean searchMatrix(int[][] matrix, int target) {
    for (int[] arr : matrix) {
      if (fastCheck(arr, target)) {
        return true;
      }
    }
    return false;
  }

  private boolean fastCheck(int[] arr, int target) {
    if (arr == null || arr.length == 0) {
      return false;
    }
    if (arr[0] <= target && target <= arr[arr.length - 1]) {
      return binarySearch(arr, target);
    }
    return false;
  }

  private boolean binarySearch(int[] arr, int target) {
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

  // Runtime: 5 ms, faster than 100.00% of Java online submissions for Search a 2D Matrix II.
  // Memory Usage: 43.6 MB, less than 98.11% of Java online submissions for Search a 2D Matrix II.
  // another solution, O(n + m) time and O(1) space complexity
  public boolean searchMatrixV2(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0) {
      return false;
    }
    int row = matrix.length - 1;
    int col = 0;
    while (row >= 0 && col < matrix[0].length) {
      if (matrix[row][col] > target) {
        row--;
      } else if (matrix[row][col] < target) {
        col++;
      } else {
        return true;
      }
    }
    return false;
  }
}
