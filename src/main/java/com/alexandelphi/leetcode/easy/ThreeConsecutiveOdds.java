package com.alexandelphi.leetcode.easy;

public class ThreeConsecutiveOdds {
  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Three Consecutive Odds.
  // Memory Usage: 39.2 MB, less than 81.38% of Java online submissions for Three Consecutive Odds.
  public boolean threeConsecutiveOdds(int[] arr) {
    for (int i = 2; i < arr.length; i++) {
      int a = arr[i - 2];
      int b = arr[i - 1];
      int c = arr[i];
      if (a % 2 != 0 && b % 2 != 0 && c % 2 != 0) {
        return true;
      }
    }
    return false;
  }
}
