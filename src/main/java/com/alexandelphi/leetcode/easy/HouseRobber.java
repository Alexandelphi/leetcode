package com.alexandelphi.leetcode.easy;

//Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber.
//Memory Usage: 34.3 MB, less than 100.00% of Java online submissions for House Robber.

public class HouseRobber {
  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    if (nums.length == 2) {
      return Math.max(nums[0], nums[1]);
    }

    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);
    for (int i = 2; i < nums.length; i++) {
      dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
    }
    return dp[nums.length - 1];
  }

}