package com.alexandelphi.leetcode.medium;

public class MinimumPathSum {
  //  Runtime: 2 ms, faster than 91.10% of Java online submissions for Minimum Path Sum.
  //  Memory Usage: 42.9 MB, less than 52.70% of Java online submissions for Minimum Path Sum.
  public int minPathSum(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return -1;
    }
    int m = grid.length;
    int n = grid[0].length;
    for (int row = 0; row < m; row++) {
      for (int col = 0; col < n; col++) {
        if (row > 0 && col > 0) {
          grid[row][col] += Math.min(grid[row][col - 1], grid[row - 1][col]);
        } else if (col > 0) {
          grid[row][col] += grid[row][col - 1];
        } else if (row > 0) {
          grid[row][col] += grid[row - 1][col];
        }
      }
    }
    return grid[m - 1][n - 1];
  }
}
