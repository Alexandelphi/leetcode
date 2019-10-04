package com.alexandelphi.leetcode.easy;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {

  // my naive solution - the time complexity O(n*log(n)) and the space O(n)
  public int findUnsortedSubarray(int[] nums) {
    int[] sortedCopy = nums.clone();
    Arrays.sort(sortedCopy);

    int start = 0;
    int end = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != sortedCopy[i])  {
        start = i;
        break;
      }
    }
    for (int i = nums.length - 1; i >= start; i--) {
      if (nums[i] != sortedCopy[i])  {
        end = i;
        break;
      }
    }
    int result = Math.abs(end - start);
    return result == 0 ? result : result + 1;
  }
}
