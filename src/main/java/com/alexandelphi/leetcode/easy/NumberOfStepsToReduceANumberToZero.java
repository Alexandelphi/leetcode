package com.alexandelphi.leetcode.easy;

public class NumberOfStepsToReduceANumberToZero {
  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Number of Steps to Reduce a Number to Zero.
  // Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for Number of Steps to Reduce a Number to Zero.

  public int numberOfSteps (int num) {
    int count = 0;
    while (num != 0) {
      if ((num & 1) == 0) { // (num % 2) is the same as (num & 1)
        num /= 2;
        count++;
      } else {
        num--;
        count++;
      }
    }
    return count;
  }
}
