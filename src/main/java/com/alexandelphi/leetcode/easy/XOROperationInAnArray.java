package com.alexandelphi.leetcode.easy;

public class XOROperationInAnArray {
  // Runtime: 0 ms, faster than 100.00% of Java online submissions for XOR Operation in an Array.
  // Memory Usage: 36 MB, less than 86.60% of Java online submissions for XOR Operation in an Array.
  public int xorOperation(int n, int start) {
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = start + 2 * i;
    }
    for (int i = 1; i < n; i++) {
      nums[i] ^= nums[i - 1];
    }
    return nums[n - 1];
  }
}
