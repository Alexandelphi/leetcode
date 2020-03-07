package com.alexandelphi.leetcode.easy;

public class HowManyNumbersAreSmallerThanTheCurrentNumber {

  // Runtime: 13 ms, faster than 36.35% of Java online submissions for How Many Numbers Are Smaller Than the Current Number.
  // Memory Usage: 41.6 MB, less than 100.00% of Java online submissions for How Many Numbers Are Smaller Than the Current Number.
  // brute force solution
  public int[] smallerNumbersThanCurrent(int[] nums) {
    int[] result = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums.length; j++) {
        if (nums[i] > nums[j]) {
          result[i]++;
        }
      }
    }
    return result;
  }

  // Runtime: 2 ms, faster than 81.79% of Java online submissions for How Many Numbers Are Smaller Than the Current Number.
  // Memory Usage: 41.4 MB, less than 100.00% of Java online submissions for How Many Numbers Are Smaller Than the Current Number.
  // as we have only 0 <= nums[i] <= 100 then we can count nums at first
  public int[] smallerNumbersThanCurrentV2(int[] nums) {
    int[] table = new int[102];
    for (int val : nums) {
      table[val]++;
    }
    int[] result = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums[i]; j++) {
        result[i] += table[j];
      }
    }
    return result;
  }

  // Runtime: 1 ms, faster than 99.72% of Java online submissions for How Many Numbers Are Smaller Than the Current Number.
  // Memory Usage: 41.4 MB, less than 100.00% of Java online submissions for How Many Numbers Are Smaller Than the Current Number.
  // optimised version
  public int[] smallerNumbersThanCurrentV3(int[] nums) {
    int[] table = new int[101];
    for (int val : nums) {
      table[val]++;
    }
    for (int i = 1; i < table.length; i++) {
      table[i] += table[i - 1];
    }
    int[] result = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        result[i] = 0;
      } else {
        result[i] = table[nums[i] - 1];
      }
    }
    return result;
  }
}
