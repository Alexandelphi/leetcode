package com.alexandelphi.leetcode.easy;

public class RotateArray {
  // my naive solution
  public void rotate(int[] nums, int k) {
    if (nums.length == 1) {
      return;
    }

    // it's a relly important/crucial moment
    k = k % nums.length;

    int[] arr = new int[nums.length];
    for (int i = nums.length - k, j = 0; j < nums.length; i++, j++) {
      if (j == k) {
        i = 0;
      }
      arr[j] = nums[i];
    }
    for (int i = 0; i < nums.length; i++) {
      nums[i] = arr[i];
    }
  }

  // my improved solution
  class Solution {
    public void rotateV2(int[] nums, int k) {
      if (nums.length == 1) {
        return;
      }
      k = k % nums.length;
      reverseArray(nums, 0, nums.length - 1);
      reverseArray(nums, 0, k - 1);
      reverseArray(nums, k, nums.length - 1);
    }

    private void reverseArray(int[] arr, int start, int end) {
      while (start < end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
        start++;
        end--;
      }
    }
  }
}
