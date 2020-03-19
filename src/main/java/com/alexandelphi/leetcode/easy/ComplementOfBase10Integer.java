package com.alexandelphi.leetcode.easy;

public class ComplementOfBase10Integer {
  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Complement of Base 10 Integer.
  // Memory Usage: 36.2 MB, less than 11.11% of Java online submissions for Complement of Base 10 Integer.
  // my straightforward approach, we find the first "1" bit and then write a new value with reverted bits
  public int bitwiseComplement(int n) {
    if (n == 0) {
      return 1;
    }
    int value = 0;
    boolean state = false;
    for (int i = 30; i >= 0; i--) {
      int bit = n & (1 << i);
      if (bit != 0 && state == false) {
        state = true;
      }
      if (state == true) {
        value = value + (bit != 0 ? 0 : 1); // reverting bits, if we get "1", we add "0" and vice versa
        if (i > 0) {
          value <<= 1;
        }
      }
    }
    return value;
  }

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Complement of Base 10 Integer.
  // Memory Usage: 36.2 MB, less than 11.11% of Java online submissions for Complement of Base 10 Integer.
  // optimised version
  // the idea is to do XOR between "111..111 >= n" and "n"
  // 101 ^ 111 = 010
  // 1010 ^ 1111 = 0101
  public int bitwiseComplementV2(int n) {
    int res = 1;
    while (res < n) {
      res <<= 1;
      res |= 1;
    }
    return n ^ res;
  }
}
