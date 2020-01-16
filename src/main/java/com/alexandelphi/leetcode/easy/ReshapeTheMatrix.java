package com.alexandelphi.leetcode.easy;

public class ReshapeTheMatrix {

  // Runtime: 1 ms, faster than 100.00% of Java online submissions for Reshape the Matrix.
  // Memory Usage: 53.3 MB, less than 5.55% of Java online submissions for Reshape the Matrix.
  public int[][] matrixReshape(int[][] nums, int r, int c) {
    int m = nums.length; // m - row
    int n = nums[0].length; // n - col
    if (m * n != r * c) {
      return nums;
    }

    int[][] result = new int [r][c];
    int row = 0;
    int col = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        result[row][col] = nums[i][j];
        col++;
        if (col == c) {
          col = 0;
          row++;
        }

      }
    }
    return result;
  }
}
