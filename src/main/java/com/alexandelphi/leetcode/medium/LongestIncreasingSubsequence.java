package com.alexandelphi.leetcode.medium;

public class LongestIncreasingSubsequence {

  // Runtime: 14 ms, faster than 33.55% of Java online submissions for Longest Increasing Subsequence.
  // Memory Usage: 37.8 MB, less than 27.00% of Java online submissions for Longest Increasing Subsequence.
  // my dp solution
  public int lengthOfLIS(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return 1;
    }
    int n = nums.length;
    int[] dp = new int[n];
    int max = 0;
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
          max = Math.max(max, dp[i]);
        }
      }
    }
    return max + 1;
  }
}
