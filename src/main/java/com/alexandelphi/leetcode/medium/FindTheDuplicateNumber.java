package com.alexandelphi.leetcode.medium;

import java.util.Arrays;

public class FindTheDuplicateNumber {

  // my naive solution
  public int findDuplicate(int[] nums) {
    Arrays.sort(nums);
    Integer prev = null;
    for (int i : nums) {
      if (prev != null && i == prev) {
        return i;
      }
      prev = i;
    }
    return -1;
  }

  // floyd's cycle detection algorithm as used here
  public int findDuplicate2(int[] nums) {
    int slow = nums[0];
    int fast = nums[0];
    do {
      slow = nums[slow];
      fast = nums[nums[fast]];
    } while (slow != fast);

    int ptr1 = nums[0];
    int ptr2 = slow;
    while (ptr1 != ptr2) {
      ptr1 = nums[ptr1];
      ptr2 = nums[ptr2];
    }
    return ptr1;
  }
}
