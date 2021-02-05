package com.alexandelphi.leetcode.easy;

public class CreateTargetArrayInTheGivenOrder {
  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Create Target Array in the Given Order.
  // Memory Usage: 39.1 MB, less than 7.54% of Java online submissions for Create Target Array in the Given Order.
  public int[] createTargetArray(int[] nums, int[] index) {
    int[] result = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      shiftInsert(nums[i], result, index[i]);
    }
    return result;
  }

  private void shiftInsert(int newEl, int[] nums, int startIndex) {
    // shift
    for (int i = nums.length - 1; i > startIndex; i--) {
      nums[i] = nums[i - 1];
    }
    // insert
    nums[startIndex] = newEl;
  }
}
