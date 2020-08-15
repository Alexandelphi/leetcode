package com.alexandelphi.leetcode.easy;

public class ShuffleString {
  // Runtime: 1 ms, faster than 100.00% of Java online submissions for Shuffle String.
  // Memory Usage: 39.6 MB, less than 72.57% of Java online submissions for Shuffle String.
  public String restoreString(String s, int[] indices) {
    char[] result = new char[s.length()];
    for (int i = 0; i < s.length(); i++) {
      result[indices[i]] = s.charAt(i);
    }
    return new String(result);
  }
}
