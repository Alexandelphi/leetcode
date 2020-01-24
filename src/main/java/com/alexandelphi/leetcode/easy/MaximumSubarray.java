package com.alexandelphi.leetcode.easy;

// Kadane's algorithm
public class MaximumSubarray {

  // Runtime: 1 ms, faster than 64.09% of Java online submissions for Maximum Subarray.
  // Memory Usage: 48.6 MB, less than 5.16% of Java online submissions for Maximum Subarray.
  // greedy approach
  public int maxSubArray(int[] nums) {
    int localMax = nums[0];
    int globalMax = nums[0];
    for (int i = 1; i < nums.length; i++) {
      localMax = Math.max(nums[i], localMax + nums[i]);
      globalMax = Math.max(localMax, globalMax);
    }
    return globalMax;
  }


  // Runtime: 1 ms, faster than 64.09% of Java online submissions for Maximum Subarray.
  // Memory Usage: 41.7 MB, less than 5.16% of Java online submissions for Maximum Subarray.
  // dp solution
  public int maxSubArrayV2(int[] nums) {
    int maxSum = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] > 0) {
        nums[i] += nums[i - 1];
      }
      maxSum = Math.max(nums[i], maxSum);
    }
    return maxSum;
  }
}
