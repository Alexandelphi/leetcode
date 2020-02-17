package com.alexandelphi.leetcode.easy;

public class CountNegativeNumbersInASortedMatrix {

  // Runtime: 1 ms, faster than 66.90% of Java online submissions for Count Negative Numbers in a Sorted Matrix.
  // Memory Usage: 41.8 MB, less than 100.00% of Java online submissions for Count Negative Numbers in a Sorted Matrix.
  // my brute force approach with small optimisation
  public int countNegatives(int[][] grid) {
    int row = grid.length;
    int col = grid[0].length;
    int result = 0;
    for (int r = 0; r < row; r++) {
      for (int c = col - 1; c >= 0; c--) {
        if (grid[r][c] < 0) {
          result++;
        } else {
          break;
        }
      }
    }
    return result;
  }
}
