package com.alexandelphi.leetcode.easy;

public class ReplaceWithGreatestElementOnRightSide {
  // Runtime: 1 ms, faster than 100.00% of Java online submissions for Replace Elements with Greatest Element on Right Side.
  // Memory Usage: 48.7 MB, less than 100.00% of Java online submissions for Replace Elements with Greatest Element on Right Side.
  public int[] replaceElements(int[] arr) {
    int max = arr[arr.length - 1];
    for (int i = arr.length - 2; i >= 0; i--) {
      int tmp = arr[i];
      arr[i] = max;
      max = Math.max(max, tmp);
    }
    arr[arr.length - 1] = -1;
    return arr;
  }
}
