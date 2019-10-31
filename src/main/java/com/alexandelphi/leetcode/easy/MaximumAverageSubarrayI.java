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
}
