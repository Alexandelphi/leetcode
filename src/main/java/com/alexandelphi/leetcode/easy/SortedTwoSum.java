package com.alexandelphi.leetcode.easy;

import java.util.Arrays;

public class SortedTwoSum {
  public int[] twoSum(int[] numbers, int target) {
    for (int i = 0; i < numbers.length; i++) {
      int searchResult = binarySearch(numbers, i + 1, target - numbers[i]);
      if (searchResult != -1) {
        return new int[]{i + 1, searchResult + 1};
      }
    }
    return null;
  }

  public int binarySearch(int[] arr, int low, int target) {
    int high = arr.length - 1;
    int mid;
    while (low <= high) {
      mid = (low + high) / 2;
      if (target < arr[mid]) {
        high = mid - 1;
      } else {
        if (target > arr[mid]) {
          low = mid + 1;
        } else {
          return mid;
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
//    int[] arr = new int[]{1,2,3,4,4,9,56,90};
    int[] arr = new int[]{2, 7, 11, 15};
    System.out.println(Arrays.toString(new SortedTwoSum().twoSum(arr, 9)));
  }
}
