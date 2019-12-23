package com.alexandelphi.leetcode.easy;

public class PlusOne {

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Plus One.
  // Memory Usage: 35.3 MB, less than 97.58% of Java online submissions for Plus One.
  // I know it's not so concise and clean, but it's my straightforward solution
  // I hope to optimise it later on
  public int[] plusOne(int[] digits) {
    int carry = 0;
    for (int i = digits.length - 1; i >= 0; i--) {
      if (i == digits.length - 1) {
        digits[i] = digits[i] + carry + 1;
      } else {
        digits[i] = digits[i] + carry;
      }
      if (digits[i] > 9) {
        digits[i] = 0;
        carry = 1;
      } else {
        carry = 0;
      }
    }
    int[] result = null;
    if (carry == 1) {
      result = new int[digits.length + 1];
      result[0] = 1;
      System.arraycopy(digits, 0, result, 1, digits.length);
    }
    return result != null ? result : digits;
  }
}
