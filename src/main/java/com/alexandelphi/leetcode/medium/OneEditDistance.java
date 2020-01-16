package com.alexandelphi.leetcode.medium;

public class OneEditDistance {

  // Runtime: 1 ms, faster than 98.76% of Java online submissions for One Edit Distance.
  // Memory Usage: 42.6 MB, less than 14.71% of Java online submissions for One Edit Distance.
  // finally solved as I wanted and without substring method
  // more optimal version of it, will be added soon :-)
  public boolean isOneEditDistance(String s, String t) {
    int diffSize = Math.abs(s.length() - t.length());
    if (diffSize > 1) return false;
    int changes = 0;
    if (diffSize == 0) {
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) != t.charAt(i)) changes++;
        if (changes > 1) return false;
      }
    } else {
      int i = 0;
      int j = 0;
      while (i < s.length() && j < t.length()) {
        if (s.charAt(i) != t.charAt(j)) {
          changes++;
          if (s.length() > t.length()) {
            i++;
          } else {
            j++;
          }
        } else {
          i++;
          j++;
        }
      }
      if (changes > 1) return false;
    }
    if ((diffSize == 0 && changes == 1) || (diffSize == 1 && changes <= 1)) {
      return true;
    } else {
      return false;
    }
  }
}
