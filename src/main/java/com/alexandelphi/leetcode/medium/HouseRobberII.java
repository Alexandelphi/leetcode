package com.alexandelphi.leetcode.medium;

public class HouseRobberII {

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber II.
  // Memory Usage: 37.2 MB, less than 6.67% of Java online submissions for House Robber II.
  // Wow, finally!! I did it! I wan't able to solve this task for a long time, but now I can do that!
  // It turned out that it's not so difficult, just need more practice and you'll be able to solve anything.
  // I'm planing to add an optimized solution as well.
  // Dynamic Programing solution
  public int rob(int[] nums) {
    return Math.max(rob(nums, 1, 0), rob(nums, 0, 1));
  }

  private int rob(int[] nums, int start, int end) {
    if (nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    int[] dp = new int[nums.length];
    if (nums.length > start) {
      dp[start] = nums[start];
    }
    if (nums.length > start + 1) {
      dp[start + 1] = Math.max(nums[start], nums[start +1]);
    }
    for (int i = start + 2; i < nums.length - end; i++) {
      dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
    }
    return dp[dp.length - 1 - end];
  }


  // Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber II.
  // Memory Usage: 37.3 MB, less than 6.67% of Java online submissions for House Robber II.
  // my attempt to improve space complexity, I'm not sure but it can be LeetCode issue ...
  // Time O(n), Space O(1) complexity
  public int robV2(int[] nums) {
    int n = nums.length;
    if (n == 0) return 0;
    if (n == 1) return nums[0];
    return Math.max(rob(nums, 1, n - 1), rob(nums, 0, n - 2));
  }

  private int robV2(int[] nums, int start, int end) {
    int x1 = 0, x2 = 0;
    for (int i = start; i <= end; i++) {
      int res = Math.max(x1 + nums[i], x2);
      x1 = x2;
      x2 = res;
    }
    return x2;
  }
}

