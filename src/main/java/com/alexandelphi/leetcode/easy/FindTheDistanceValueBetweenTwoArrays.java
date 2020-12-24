package com.alexandelphi.leetcode.easy;

// Runtime: 3 ms, faster than 80.79% of Java online submissions for Find the Distance Value Between Two Arrays.
// Memory Usage: 38.7 MB, less than 64.19% of Java online submissions for Find the Distance Value Between Two Arrays.

public class FindTheDistanceValueBetweenTwoArrays {
  public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
    int result = arr1.length;
    for (int i = 0; i < arr1.length; i++) {
      for (int j = 0; j < arr2.length; j++) {
        if (Math.abs(arr1[i] - arr2[j]) <= d) {
          result--;
          break;
        }
      }
    }
    return result;
  }
}
