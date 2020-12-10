package com.alexandelphi.leetcode.easy;

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Richest Customer Wealth.
// Memory Usage: 38.9 MB, less than 43.00% of Java online submissions for Richest Customer Wealth.
public class RichestCustomerWealth {
  public int maximumWealth(int[][] accounts) {
    int rows = accounts.length;
    int cols = accounts[0].length;
    int result = 0;

    for (int r = 0; r < rows; r++) {
      int sum = 0;
      for (int c = 0; c < cols; c++) {
        sum += accounts[r][c];
      }
      result = Math.max(result, sum);
    }
    return result;
  }
}
