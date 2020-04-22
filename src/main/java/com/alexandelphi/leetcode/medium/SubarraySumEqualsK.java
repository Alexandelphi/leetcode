package com.alexandelphi.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

  // Runtime: 204 ms, faster than 26.67% of Java online submissions for Subarray Sum Equals K.
  // Memory Usage: 40 MB, less than 66.30% of Java online submissions for Subarray Sum Equals K.
  // my brute force solution
  public int subarraySumV1(int[] nums, int k) {
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      int sum = 0;
      for (int j = i; j < nums.length; j++) {
        sum += nums[j];
        if (sum == k) {
          count++;
        }
      }
    }
    return count;
  }

  // Runtime: 11 ms, faster than 95.48% of Java online submissions for Subarray Sum Equals K.
  // Memory Usage: 40.2 MB, less than 46.74% of Java online submissions for Subarray Sum Equals K.
  // my solution with preSum + HashMap
  public int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    int count = 0;
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (map.containsKey(sum - k)) {
        count += map.get(sum - k);
      }
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return count;
  }
}
