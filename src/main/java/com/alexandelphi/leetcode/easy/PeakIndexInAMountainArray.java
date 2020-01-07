package com.alexandelphi.leetcode.easy;

public class PeakIndexInAMountainArray {

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Peak Index in a Mountain Array.
  // Memory Usage: 38.6 MB, less than 96.00% of Java online submissions for Peak Index in a Mountain Array.
  // straightforward O(n) solution
  public int peakIndexInMountainArray(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
        return i;
      }
    }
    return -1;
  }

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Peak Index in a Mountain Array.
  // Memory Usage: 39.7 MB, less than 80.00% of Java online submissions for Peak Index in a Mountain Array.
  // binary search approach
  public int peakIndexInMountainArrayV2(int[] arr) {
    int low = 0;
    int high = arr.length;
    while (low < high) {
      int mid = low + (high - low) / 2;
      if (arr[mid] < arr[mid + 1]) {
        low = mid + 1;
      } else if (arr[mid] < arr[mid - 1]) {
        high = mid;
      } else {
        return mid;
      }
    }
    return low;
  }

}
