package com.alexandelphi.leetcode.easy;

public class ElementAppearingMoreThanTwentyFivePercentInSortedArray {

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Element Appearing More Than 25% In Sorted Array.
  // Memory Usage: 40.2 MB, less than 100.00% of Java online submissions for Element Appearing More Than 25% In Sorted Array.
  // count approach
  public int findSpecialInteger(int[] arr) {
    int n = arr.length / 4;
    int res = -1;
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      if (res == arr[i]) {
        count++;
      } else {
        res = arr[i];
        count = 1;
      }
      if (count > n) {
        return res;
      }
    }
    return res;
  }
}
