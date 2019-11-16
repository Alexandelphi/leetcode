package com.alexandelphi.leetcode.easy;

public class MonotonicArray {

  // Runtime: 2 ms, faster than 76.31% of Java online submissions for Monotonic Array.
  // Memory Usage: 50.7 MB, less than 80.95% of Java online submissions for Monotonic Array.

  public boolean isMonotonic(int[] A) {
    if (A == null || A.length == 0 || A.length == 1) {
      return true;
    }
    int incNums = 0;
    int decNums = 0;
    for (int i = 1; i < A.length; i++) {
      if (A[i] > A[i - 1]) {
        incNums++;
      }
      if (A[i] < A[i - 1]) {
        decNums++;
      }
    }
    if (incNums != 0 && decNums != 0) {
      return false;
    }
    return true;
  }
}
