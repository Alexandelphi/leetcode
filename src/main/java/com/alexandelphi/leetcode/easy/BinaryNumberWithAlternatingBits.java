package com.alexandelphi.leetcode.easy;

public class BinaryNumberWithAlternatingBits {
  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Number with Alternating Bits.
  // Memory Usage: 36.2 MB, less than 12.50% of Java online submissions for Binary Number with Alternating Bits.
  // bit manipulation
  public boolean hasAlternatingBits(int n) {
    int status = -1;
    while (n != 0) {
      if ((n & 1) != 0 && status != 1) {
        status = 1;
      } else if ((n & 1) == 0 && status != 0) {
        status = 0;
      } else {
        return false;
      }
      n >>= 1;
    }
    return true;
  }
}
