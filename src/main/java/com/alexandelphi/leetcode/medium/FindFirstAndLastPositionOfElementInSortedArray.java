package com.alexandelphi.leetcode.medium;


// Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
// Memory Usage: 43 MB, less than 98.58% of Java online submissions for Find First and Last Position of Element in Sorted Array.

public class FindFirstAndLastPositionOfElementInSortedArray {
  public int[] searchRange(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return new int[] {-1, -1};
    }
    int[] result = new int[] {findFirst(nums, target), findLast(nums, target)};
    if (result[0] >= nums.length || nums[result[0]] != target) {
      result[0] = -1;
    }
    if (result[0] < 0 || nums[result[1]] != target) {
      result[1] = -1;
    }
    return result;
  }

  private int findFirst(int[] nums, int target) {
    return binarySearch(nums, target);
  }

  private int findLast(int[] nums, int target) {
    return binarySearch(nums, target + 1) - 1;
  }

  private int binarySearch(int[] nums, int target) {
    int low = 0;
    int high = nums.length;
    while (low < high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] < target) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }
    return low;
  }
}
