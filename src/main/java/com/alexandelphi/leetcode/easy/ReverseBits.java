package com.alexandelphi.leetcode.easy;

public class ReverseBits {
  // Runtime: 1 ms, faster than 99.60% of Java online submissions for Reverse Bits.
  // Memory Usage: 38.2 MB, less than 7.32% of Java online submissions for Reverse Bits.

  // you need treat n as an unsigned value
  public int reverseBits(int n) {
    int result = 0;
    for (int i = 0; i < 32; i++) {
      result += n & 1;
      n >>>= 1;
      if (i < 31) {
        result <<= 1;
      }
    }
    return result;
  }
}
