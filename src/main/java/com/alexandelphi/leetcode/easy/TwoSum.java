package com.alexandelphi.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

  public int[] twoSumBruteForce(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[]{i, j};
        }
      }
    }
    return null;
  }

  public int[] twoSumHashMap(int[] nums, int target) {
    Map<Integer, Integer> cache = new HashMap<>();
    for(int i = 0; i < nums.length; i++){
      Integer first = cache.get(target - nums[i]);
      if (first != null) {
        return new int[]{first, i};
      }
      cache.put(nums[i], i);
    }
    return null;
  }

  public static void main(String[] args) {
    int[] arr = new int[]{6,5,3,10,4,2,1,0};

    System.out.println(Arrays.toString(new TwoSum().twoSumBruteForce(arr, 4)));
    System.out.println(Arrays.toString(new TwoSum().twoSumHashMap(arr, 4)));
  }
}
