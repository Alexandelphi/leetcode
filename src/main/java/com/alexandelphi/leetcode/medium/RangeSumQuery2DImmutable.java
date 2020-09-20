package com.alexandelphi.leetcode.medium;


// Runtime: 10 ms, faster than 100.00% of Java online submissions for Range Sum Query 2D - Immutable.
// Memory Usage: 45.1 MB, less than 77.99% of Java online submissions for Range Sum Query 2D - Immutable.

public class RangeSumQuery2DImmutable {
  private int[][] mat;
  private int rows;
  private int cols;

  public RangeSumQuery2DImmutable(int[][] matrix) {
    mat = matrix;
    if (mat == null || mat.length == 0) {
      return;
    }
    rows = mat.length;
    cols = mat[0].length;
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols - 1; c++) {
        mat[r][c + 1] += mat[r][c];
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    if (mat == null || mat.length == 0) {
      return 0;
    }
    int sum = 0;
    for (int r = row1; r <= row2; r++) {
      if (col1 == 0) {
        sum += mat[r][col2];
      } else {
        sum += mat[r][col2] - mat[r][col1 - 1];
      }
    }
    return sum;
  }
}
