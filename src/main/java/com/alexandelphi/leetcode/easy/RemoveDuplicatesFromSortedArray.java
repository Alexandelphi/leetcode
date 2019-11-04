package com.alexandelphi.leetcode.easy;

public class RemoveDuplicatesFromSortedArray {


 // Runtime: 1 ms, faster than 97.82% of Java online submissions for Remove Duplicates from Sorted Array.
 // Memory Usage: 39.5 MB, less than 97.87% of Java online submissions for Remove Duplicates from Sorted Array.

  public int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int i = 0;
    int j = 0;
    int prev = nums[0];
    while (j < nums.length) {
      if (prev != nums[j]) {
        i++;
        nums[i] = nums[j];
      }
      prev = nums[j];
      j++;
    }
    return i + 1;
  }
}
