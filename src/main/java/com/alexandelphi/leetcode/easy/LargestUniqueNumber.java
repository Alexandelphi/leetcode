package com.alexandelphi.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class LargestUniqueNumber {
  // Runtime: 3 ms, faster than 65.98% of Java online submissions for Largest Unique Number.
  // Memory Usage: 39.2 MB, less than 33.33% of Java online submissions for Largest Unique Number.
  // straightforward solution with HashMap
  public int largestUniqueNumber(int[] a) {
    Map<Integer, Integer> map = new HashMap<>();
    int maxNum = -1;
    for (int num : a) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() == 1) {
        maxNum = Math.max(maxNum, entry.getKey());
      }
    }
    return maxNum;
  }

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Largest Unique Number.
  // Memory Usage: 38.4 MB, less than 33.33% of Java online submissions for Largest Unique Number.
  // as we have 0 <= 1000 num values we can use array instead of HashMap
  public int largestUniqueNumberV2(int[] arr) {
    int[] table = new int[1001];
    for (int val : arr) {
      table[val]++;
    }
    int maxNum = -1;
    for (int val : arr) {
      if (table[val] == 1) {
        maxNum = Math.max(maxNum, val);
      }
    }
    return maxNum;
  }

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Largest Unique Number.
  // Memory Usage: 38.5 MB, less than 33.33% of Java online submissions for Largest Unique Number.
  // also we can improve searching part in the second loop
  public int largestUniqueNumberV3(int[] arr) {
    int[] table = new int[1001];
    for (int val : arr) {
      table[val]++;
    }
    for (int i = 1000; i >= 0; i--) {
      if (table[i] == 1) {
        return i;
      }
    }
    return -1;
  }
}
