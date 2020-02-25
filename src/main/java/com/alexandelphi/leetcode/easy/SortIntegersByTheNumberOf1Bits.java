package com.alexandelphi.leetcode.easy;

import java.util.Arrays;

public class SortIntegersByTheNumberOf1Bits {
  // Runtime: 27 ms, faster than 13.99% of Java online submissions for Sort Integers by The Number of 1 Bits.
  // Memory Usage: 41.4 MB, less than 100.00% of Java online submissions for Sort Integers by The Number of 1 Bits.
  // sort and bit manipulation
  public int[] sortByBits(int[] arr) {
    return Arrays.stream(arr)
        .boxed()
        .sorted((a, b) -> countBits(a) == countBits(b) ? a - b : countBits(a) - countBits(b))
        .mapToInt(Integer::intValue)
        .toArray();
  }
  // as it marked as Bit Manipulation I use my own logic instead of Integer.bitCount();
  private int countBits(int num) {
    int count = 0;
    for (int i = 0; i < 32; i++) {
      if ((num & (1 << i)) != 0) {
        count++;
      }
    }
    return count;
  }


  // Runtime: 10 ms, faster than 47.62% of Java online submissions for Sort Integers by The Number of 1 Bits.
  // Memory Usage: 41.2 MB, less than 100.00% of Java online submissions for Sort Integers by The Number of 1 Bits.
  // solution with using Integer.bitCount()
  // I took a look at bitCount() logic and there is some magic inside, it has O(1) time complexity

  public int[] sortByBitsV2(int[] arr) {
    return Arrays.stream(arr)
        .boxed()
        .sorted((a, b) -> Integer.bitCount(a) == Integer.bitCount(b) ? a - b : Integer.bitCount(a) - Integer.bitCount(b))
        .mapToInt(Integer::intValue)
        .toArray();
  }
}
