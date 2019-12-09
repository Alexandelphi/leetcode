package com.alexandelphi.leetcode.easy;

public class ShortestDistanceToCharacter {

  // Runtime: 1 ms, faster than 99.13% of Java online submissions for Shortest Distance to a Character.
  // Memory Usage: 36 MB, less than 100.00% of Java online submissions for Shortest Distance to a Character.
  public int[] shortestToChar(String s, char c) {
    int n = s.length();
    int position = -n;
    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == c) {
        position = i;
      }
      result[i] = Math.abs(i - position);
    }
    for (int i = n - 1; i >= 0; i--) {
      if (s.charAt(i) == c) {
        position = i;
      }
      result[i] = Math.min(result[i], Math.abs(i - position));
    }
    return result;
  }
}
