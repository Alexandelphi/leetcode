package com.alexandelphi.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleBy5 {
  // Runtime: 2 ms, faster than 100.00% of Java online submissions for Binary Prefix Divisible By 5.
  // Memory Usage: 42.4 MB, less than 6.75% of Java online submissions for Binary Prefix Divisible By 5.
  // some mix of math and bitwise (it's optional and I could use (num * 2 + 1) instead of (num << 1) | arr[i]
  public List<Boolean> prefixesDivBy5(int[] arr) {
    List<Boolean> result = new ArrayList<>();
    int num = 0;
    for (int i = 0; i < arr.length; i++) {
      num = ((num << 1) | arr[i]) % 5;
      result.add(num == 0);
    }
    return result;
  }
}
