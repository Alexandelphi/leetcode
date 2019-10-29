package com.alexandelphi.leetcode.medium;

public class SearchInSortedArrayOfUnknownSize {

//  Runtime: 2 ms, faster than 100.00% of Java online submissions for Search in a Sorted Array of Unknown Size.
//  Memory Usage: 38.9 MB, less than 100.00% of Java online submissions for Search in a Sorted Array of Unknown Size.

  public int search(ArrayReader reader, int target) {
    int low = 0;
    int high = Integer.MAX_VALUE;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (reader.get(mid) == target) {
        return mid;
      } else if (reader.get(mid) < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return -1;
  }
}


class ArrayReader {
  private int[] arr = new int[10];
  public int get(int i) {
    if (i < 0 || i >= arr.length) {
      return Integer.MAX_VALUE;
    }
    return arr[i];
  }
}
