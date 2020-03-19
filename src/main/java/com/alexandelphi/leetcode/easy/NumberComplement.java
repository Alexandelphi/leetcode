package com.alexandelphi.leetcode.easy;

public class NumberComplement {
  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Number Complement.
  // Memory Usage: 36.6 MB, less than 8.70% of Java online submissions for Number Complement.
  // the idea is to do XOR between num and oneBitsMask
  // 101 ^ 111 = 010
  // 1101 ^ 1111 = 0010
  // so, we just need to generate a bit mask with enough "1" bits
  public int findComplement(int num) {
    int oneBitsMask = 1;
    while (oneBitsMask < num) {
      oneBitsMask = (oneBitsMask << 1) | 1;
    }
    return num ^ oneBitsMask;
  }
}
