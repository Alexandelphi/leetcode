package com.alexandelphi.leetcode.easy;

import java.util.Arrays;

public class CanMakeArithmeticProgressionFromSequence {
  // Runtime: 1 ms, faster than 95.39% of Java online submissions for Can Make Arithmetic Progression From Sequence.
  // Memory Usage: 39.1 MB, less than 57.48% of Java online submissions for Can Make Arithmetic Progression From Sequence.
  public boolean canMakeArithmeticProgression(int[] arr) {
    Arrays.sort(arr);
    int dist = arr[1] - arr[0];
    for (int i = 2; i < arr.length; i++) {
      if (arr[i] - arr[i - 1] != dist) {
        return false;
      }
    }
    return true;
  }
}