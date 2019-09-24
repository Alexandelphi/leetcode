package com.alexandelphi.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingNumber {
  public int missingNumber(int[] nums) {
    Set<Integer> cache = new HashSet<>();
    for (int i : nums) {
      cache.add(i);
    }

    int n = nums.length + 1;
    for (int i = 0; i < n; i++) {
      if (!cache.contains(i)) {
        return i;
      }
    }
    return -1;
  }

  public int missingNumber2(int[] nums) {
    int n = nums.length;
    Arrays.sort(nums);

    if (nums[n - 1] != n) {
      return n;
    }
    if (nums[0] != 0) {
      return 0;
    }

    for (int i = 1; i < n; i++) {
      int expectedNum = nums[i - 1] + 1;
      if (expectedNum != nums[i]) {
        return expectedNum;
      }

    }
    return -1;
  }
}
