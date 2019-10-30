package com.alexandelphi.leetcode.medium;

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Binary Search Trees.
// Memory Usage: 32.8 MB, less than 5.55% of Java online submissions for Unique Binary Search Trees.
// https://en.wikipedia.org/wiki/Catalan_number

public class UniqueBinarySearchTrees {
  public int numTreesWithDP(int n) {
    int[] dp = new int[n + 1];
    if (n >= 0) {
      dp[0] = 1;
    }
    if (n >= 1) {
      dp[1] = 1;
    }
    for (int i = 2; i <= n; i++) {
      for (int j = 0; j < i; j++) {
        dp[i] += dp[j] * dp[i - j - 1];
      }
    }
    return dp[n];
  }

  public int numTreesWithCatalanFormula(int n) {
    long c = 1;
    for (int i = 1; i < n; i++) {
      c = c * 2 * (2 * i + 1) / (i + 2);
    }
    return (int) c;
  }
}
