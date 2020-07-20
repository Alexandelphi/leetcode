package com.alexandelphi.leetcode.medium;

//    Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
//
//    Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
//
//    Note: You are not suppose to use the library's sort function for this problem.
//
//    Example:
//
//    Input: [2,0,2,1,1,0]
//    Output: [0,0,1,1,2,2]
//    Follow up:
//
//    A rather straight forward solution is a two-pass algorithm using counting sort.
//    First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
//    Could you come up with a one-pass algorithm using only constant space?

public class SortColors {

  // Runtime: 1 ms, faster than 15.37% of Java online submissions for Sort Colors.
  // Memory Usage: 39.8 MB, less than 5.04% of Java online submissions for Sort Colors.
  // my straightforward solution
  public void sortColors(int[] nums) {
    int red = 0;
    int white = 0;
    int blue = 0;  // we don't need "blue" count, but I kept it here for better understanding
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        red++;
      } else if (nums[i] == 1) {
        white++;
      } else {
        blue++;
      }
    }
    for (int i = 0; i < nums.length; i++) {
      if (red > 0) {
        nums[i] = 0;
        red--;
      } else if (white > 0) {
        nums[i] = 1;
        white--;
      } else {
        nums[i] = 2;
        blue--;
      }
    }
  }

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Sort Colors.
  // Memory Usage: 38 MB, less than 44.31% of Java online submissions for Sort Colors.
  // one pass solution
  // Example: 0, 1, 2, 1, 0, 2, 1
  public void sortColorsV2(int[] nums) {
    int left = 0;
    int mid = 1;
    int right = nums.length - 1;
    while (mid <= right ) {
      if (nums[left] == 2 && (nums[right] == 0 || nums[right] == 1)) {
        swap(nums, left, right);
      } else if (nums[left] == 1 && nums[mid] == 0) {
        swap(nums, left, mid);
      } else if (nums[mid] == 2 && (nums[right] == 1 || nums[right] == 0)) {
        swap(nums, mid, right);
      }

      if (nums[left] == 0) {
        left++;
        mid++;
      } else if (nums[mid] == 1 && nums[right] != 2) {
        mid++;
      }
      if (nums[right] == 2) {
        right--;
      }
    }
  }

  private void swap(int[] nums, int left, int right) {
    int tmp = nums[left];
    nums[left] = nums[right];
    nums[right] = tmp;
  }
}
