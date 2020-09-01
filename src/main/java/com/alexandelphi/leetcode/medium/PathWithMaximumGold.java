package com.alexandelphi.leetcode.medium;

public class PathWithMaximumGold {
  // Runtime: 11 ms, faster than 98.93% of Java online submissions for Path with Maximum Gold.
  // Memory Usage: 37.2 MB, less than 61.09% of Java online submissions for Path with Maximum Gold.

  public int getMaximumGold(int[][] grid) {
    int max = 0;
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[r].length; c++) {
        if (grid[r][c] != 0) {
          max = Math.max(max, dfs(grid, r, c));
        }
      }
    }
    return max;
  }

  private int dfs(int[][] grid, int row, int col) {
    if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == 0) {
      return 0;
    }
    int value = grid[row][col];
    grid[row][col] = 0; // mark as visited

    int left = dfs(grid, row, col - 1);
    int right = dfs(grid, row, col + 1);
    int up = dfs(grid, row - 1, col);
    int down = dfs(grid, row + 1, col);

    grid[row][col] = value; // return value back

    return value + Math.max(left, Math.max(right, Math.max(up, down)));
  }
}
