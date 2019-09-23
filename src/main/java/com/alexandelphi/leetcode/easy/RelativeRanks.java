package com.alexandelphi.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RelativeRanks {
  public String[] findRelativeRanks(int[] nums) {
    int n = nums.length;
    int[] sortedCopy = nums.clone();
    Arrays.sort(sortedCopy);
    String[] strArr = new String[n];

    Map<Integer, String> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      if (i == 0) {
        map.put(sortedCopy[n - 1], "Gold Medal");
      } else if (i == 1) {
        map.put(sortedCopy[n - 2], "Silver Medal");
      } else if (i == 2) {
        map.put(sortedCopy[n - 3], "Bronze Medal");
      } else {
        map.put(sortedCopy[n - i - 1], String.valueOf(i + 1));
      }
    }
    for (int i = 0; i < n; i++) {
      strArr[i] = map.get(nums[i]);
    }
    return strArr;
  }
}
