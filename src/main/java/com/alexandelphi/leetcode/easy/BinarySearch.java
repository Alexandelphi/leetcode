package com.alexandelphi.leetcode.easy;

//704. Binary Search

public class BinarySearch {
  public int search(int[] nums, int target) {
    return binarySearch(nums, target, 0, nums.length - 1);
  }

  private int binarySearch(int[] nums, int target, int beginIndex, int endIndex) {
    if (endIndex >= 0) {
      int middle = (beginIndex + endIndex) / 2;

      if (nums[middle] == target) {
        return middle;
      }
      if ((beginIndex == endIndex)) {
        return -1;
      }

      if (nums[middle] < target) {
        return binarySearch(nums, target, middle + 1, endIndex);
      } else if (nums[middle] > target) {
        return binarySearch(nums, target, beginIndex, middle - 1);
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    BinarySearch binarySearch = new BinarySearch();

    System.out.println(binarySearch.search(new int[]{1, 2, 3, 4, 5, 6}, 4));
    System.out.println(binarySearch.search(new int[]{1, 2, 3, 4, 5, 6}, 1));
    System.out.println(binarySearch.search(new int[]{1, 2, 3, 4, 5, 6}, 6));
    System.out.println(binarySearch.search(new int[]{1, 2, 3, 4, 5, 6}, -1));
    System.out.println(binarySearch.search(new int[]{1, 2, 3, 4, 5, 6}, 7));
    System.out.println(binarySearch.search(new int[]{}, 0));
  }
}