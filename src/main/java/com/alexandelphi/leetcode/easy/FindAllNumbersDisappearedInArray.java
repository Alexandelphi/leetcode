package com.alexandelphi.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllNumbersDisappearedInArray {
  public List<Integer> findDisappearedNumbers(int[] nums) {
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