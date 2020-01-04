package com.alexandelphi.leetcode.easy;

public class SumOfDigitsInTheMinimumNumber {
  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum of Digits in the Minimum Number.
  // Memory Usage: 34.6 MB, less than 100.00% of Java online submissions for Sum of Digits in the Minimum Number.
  public int sumOfDigits(int[] values) {
    int sum = 0;
    int min = Integer.MAX_VALUE;
    for (int value : values) {
      min = Math.min(min, value);
    }
    while (min != 0) {
      sum += (min % 10);
      min /= 10;
    }
    return sum % 2 == 0 ? 1 : 0;
  }
}
