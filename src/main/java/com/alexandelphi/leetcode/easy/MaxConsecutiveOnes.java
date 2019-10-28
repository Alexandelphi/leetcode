package com.alexandelphi.leetcode.easy;

public class MaxConsecutiveOnes {
  public int findMaxConsecutiveOnes(int[] nums) {
    int max = 0;
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 1) {
        count++;
        if (i == nums.length - 1) {
          max = Math.max(max, count);
        }
      } else {
        max = Math.max(max, count);
        count = 0;
      }
    }
    return max;
  }
}
