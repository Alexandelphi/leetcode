package com.alexandelphi.leetcode.easy;

public class MaximumAverageSubarrayI {

  // Runtime: 335 ms, faster than 11.37% of Java online submissions for Maximum Average Subarray I.
  // Memory Usage: 41.7 MB, less than 76.92% of Java online submissions for Maximum Average Subarray I.
  // my straightforward solution, it's gonna be optimised

  public double findMaxAverage(int[] nums, int k) {
    double max = (double) Integer.MIN_VALUE;
    for (int i = 0; i <= nums.length - k; i++) {
      int sum = 0;
      for (int j = i; j < i + k; j++) {
        sum += nums[j];
      }
      max = Math.max(max, (double) sum / k);
    }
    return max;
  }

  // Runtime: 3 ms, faster than 97.67% of Java online submissions for Maximum Average Subarray I.
  // Memory Usage: 40.8 MB, less than 92.31% of Java online submissions for Maximum Average Subarray I.
  // Improved version by using Sliding Window technique

  public double findMaxAverageV2(int[] nums, int k) {
    int sum = 0;
    for (int i = 0; i < k; i++) {
      sum += nums[i];
    }
    int res = sum;
    for (int i = k; i < nums.length; i++) {
      sum = sum + nums[i] - nums[i - k];
      res = Math.max(res, sum);
    }
    return (double) res / k;
  }
}
