package com.alexandelphi.leetcode.easy;

public class FindNumbersWithEvenNumberOfDigits {

  //  Runtime: 1 ms, faster than 100.00% of Java online submissions for Find Numbers with Even Number of Digits.
  //  Memory Usage: 38.4 MB, less than 100.00% of Java online submissions for Find Numbers with Even Number of Digits.
  public int findNumbers(int[] nums) {
    int result = 0;
    for (int value : nums) {
      if (countDigits(value) % 2 == 0) {
        result++;
      }
    }
    return result;
  }

  private int countDigits(int value) {
    int count = 0;
    while (value != 0) {
      count++;
      value = value / 10;
    }
    return count;
  }
}
