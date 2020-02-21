package com.alexandelphi.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {
  // Runtime: 5 ms, faster than 96.19% of Java online submissions for Find All Duplicates in an Array.
  // Memory Usage: 48.1 MB, less than 47.22% of Java online submissions for Find All Duplicates in an Array.
  // Math manipulation solution
  public List<Integer> findDuplicates(int[] nums) {
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      int val = Math.abs(nums[i]) - 1;
      if (nums[val] > 0) {
        nums[val] = -nums[val];
      } else  {
        result.add(val + 1);
      }
    }
    return result;
  }
}
