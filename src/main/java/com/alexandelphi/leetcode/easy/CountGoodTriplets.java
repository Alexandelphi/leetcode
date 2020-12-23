package com.alexandelphi.leetcode.easy;

public class CountGoodTriplets {
}

// Runtime: 11 ms, faster than 70.23% of Java online submissions for Count Good Triplets.
// Memory Usage: 36.7 MB, less than 37.44% of Java online submissions for Count Good Triplets.
class Solution {
  public int countGoodTriplets(int[] arr, int a, int b, int c) {
    int result = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (Math.abs(arr[i] - arr[j]) <= a) { // important step here to save some time
          for (int k = j + 1; k < arr.length; k++) {
            if (isGood(arr[i], arr[j], arr[k], a, b, c)) {
              result++;
            }
          }
        }
      }
    }
    return result;
  }

  private boolean isGood(int one, int two, int three, int a, int b , int c) {
    return Math.abs(two - three) <= b && Math.abs(one - three) <= c;
  }
}