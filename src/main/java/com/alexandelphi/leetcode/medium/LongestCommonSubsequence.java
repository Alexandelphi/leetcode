package com.alexandelphi.leetcode.medium;

public class LongestCommonSubsequence {
  // Runtime: 9 ms, faster than 31.93% of Java online submissions for Longest Common Subsequence.
  // Memory Usage: 43.4 MB, less than 100.00% of Java online submissions for Longest Common Subsequence.
  // my DP solution
  public int longestCommonSubsequence(String text1, String text2) {
    int col = text1.length() + 1;
    int row = text2.length() + 1;
    int[][] dp = new int[row][col];
    for (int r = 1; r < row; r++) {
      for (int c = 1; c < col; c++) {
        if (text1.charAt(c - 1) == text2.charAt(r - 1)) {
          dp[r][c] = dp[r - 1][c - 1] + 1;
        } else {
          dp[r][c] = Math.max(dp[r][c - 1], dp[r - 1][c]);
        }
      }
    }
    return dp[row - 1][col - 1];
  }
}
