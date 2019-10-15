package com.alexandelphi.leetcode.medium;

public class ArrayNesting {

  // my naive solution
  public int arrayNesting(int[] nums) {
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      int start = nums[i];
      int stop = nums[start];
      int count = 1;
      while (stop != start) {
        count++;
        stop = nums[stop];
      }
      max = Math.max(max, count);
    }
    return max;
  }

  // my improved solution with using visited states like "-1" in array
  public int arrayNestingV2(int[] nums) {
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      int count = 0;
      int j = i;
      while (nums[j] >= 0) {
        int tmp = nums[j];
        nums[j] = -1;
        j = tmp;
        count++;
      }
      max = Math.max(max, count);
    }
    return max;
  }
}
