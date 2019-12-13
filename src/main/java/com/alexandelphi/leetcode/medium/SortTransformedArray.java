package com.alexandelphi.leetcode.medium;

import java.util.Arrays;

public class SortTransformedArray {

  // Runtime: 1 ms, faster than 56.81% of Java online submissions for Sort Transformed Array.
  // Memory Usage: 36.4 MB, less than 100.00% of Java online submissions for Sort Transformed Array.
  // my naive straightforward solution
  public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
    int[] copy = nums.clone();
    for (int i = 0; i < copy.length; i++) {
      copy[i] = calulateFunction(copy[i], a, b, c);
    }
    Arrays.sort(copy);
    return copy;
  }

  private int calulateFunction(int x, int a, int b, int c) {
    return (a * (int) Math.pow(x, 2)) + (b * x) + c;
  }
}
