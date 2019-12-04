package com.alexandelphi.leetcode.easy;

import java.util.Map;
import java.util.TreeMap;

public class LongestHarmoniousSubsequence {

  // Runtime: 57 ms, faster than 12.10% of Java online submissions
  // Memory Usage: 42.2 MB, less than 98.00% of Java online submissions
  // TreeMap solution
  public int findLHS(int[] nums) {
    Map<Integer, Integer> map = new TreeMap<>();
    for (int i : nums) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }
    int result = 0;
    int prevKey = Integer.MIN_VALUE;
    int prevValue = Integer.MIN_VALUE;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      int key = entry.getKey();
      int value = entry.getValue();
      if (Math.abs(key - prevKey) <= 1) {
        result = Math.max(result, prevValue + value);
      }
      prevKey = key;
      prevValue = value;
    }
    return result;
  }
}
