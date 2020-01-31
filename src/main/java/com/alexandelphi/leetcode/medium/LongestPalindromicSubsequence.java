package com.alexandelphi.leetcode.medium;

public class LongestPalindromicSubsequence {

  //     b b b a b
  //     - - - - -
  // b | 1 2 3 3 4
  // b | 0 1 2 2 3
  // b | 0 0 1 1 3
  // a | 0 0 0 1 1
  // b | 0 0 0 0 1


  // Runtime: 39 ms, faster than 19.12% of Java online submissions for Longest Palindromic Subsequence.
  // Memory Usage: 53.6 MB, less than 5.55% of Java online submissions for Longest Palindromic Subsequence.
  // my dp solution for longest palindromic subsequence
  public int longestPalindromeSubseq(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    int n = s.length();
    int[][] dp = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int row = 0, col = i; col < n; row++, col++) {
        if (i == 0) {
          dp[row][col] = 1;
        } else if (s.charAt(row) != s.charAt(col)) {
          dp[row][col] = Math.max(dp[row][col - 1], dp[row + 1][col]);
        } else {
          dp[row][col] = dp[row + 1][col - 1] + 2;
        }
      }
    }
    return dp[0][n - 1];
  }
}
