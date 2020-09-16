package com.alexandelphi.leetcode.easy;

public class MatrixDiagonalSum {
  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Matrix Diagonal Sum.
  // Memory Usage: 45 MB, less than 38.45% of Java online submissions for Matrix Diagonal Sum.
  public int diagonalSum(int[][] mat) {
    int n = mat.length;
    int primary = 0;
    int secondary = 0;
    for (int i = 0; i < n; i++) {
      primary += mat[i][i];
    }
    for (int i = 0; i < n; i++) {
      secondary += mat[i][n - i - 1];
    }
    if (n % 2 != 0) {
      return primary + secondary - mat[n / 2][n / 2];
    } else {
      return primary + secondary;
    }
  }
}
