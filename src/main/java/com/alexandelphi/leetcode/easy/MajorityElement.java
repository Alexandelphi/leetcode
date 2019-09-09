package com.alexandelphi.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

  public int majorityElement(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i : nums) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }

    for (int i : map.keySet()) {
      if (map.get(i) > nums.length / 2) {
        return i;
      }
    }

    return -1;
  }

  public int majorityElementBySorting(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length / 2];
  }
}