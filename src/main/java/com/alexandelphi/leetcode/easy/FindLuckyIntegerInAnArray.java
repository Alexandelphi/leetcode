package com.alexandelphi.leetcode.easy;

public class FindLuckyIntegerInAnArray {
  // Runtime: 1 ms, faster than 99.45% of Java online submissions for Find Lucky Integer in an Array.
  // Memory Usage: 39 MB, less than 84.76% of Java online submissions for Find Lucky Integer in an Array.
  public int findLucky(int[] arr) {
    int[] table = new int[501];
    for (int val : arr) {
      table[val]++;
    }
    int max = -1;
    for (int i = 1; i < table.length; i++) {
      if (table[i] == i) {
        max = Math.max(max, i);
      }
    }
    return max;
  }
}
