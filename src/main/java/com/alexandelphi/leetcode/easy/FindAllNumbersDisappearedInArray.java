package com.alexandelphi.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllNumbersDisappearedInArray {
  // Runtime: 5 ms, faster than 88.93% of Java online submissions for Find All Numbers Disappeared in an Array.
  // Memory Usage: 48.2 MB, less than 37.74% of Java online submissions for Find All Numbers Disappeared in an Array.
  public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      int val = Math.abs(nums[i]) - 1;
      if (nums[val] > 0) {
        nums[val] = -nums[val];
      }
    }
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        result.add(i + 1);
      }
    }
    return result;
  }

  public List<Integer> findDisappearedNumbersWithBS(int[] nums) {
    Arrays.sort(nums);
    List<Integer> result = new ArrayList<>();
    for (int i = 1; i <= nums.length; i++) {
      if (binarySearch(nums, i) < 0) {
        result.add(i);
      }
    }
    return result;
  }

  private int binarySearch(int[] arr, int el) {
    int left = 0;
    int right = arr.length - 1;
    while (left <= right) {
      int middle = (left + right) / 2;
      if (arr[middle] == el) {
        return middle;
      } else if (arr[middle] < el) {
        left = middle + 1;
      } else {
        right = middle - 1;
      }
    }
    return -1;
  }
}