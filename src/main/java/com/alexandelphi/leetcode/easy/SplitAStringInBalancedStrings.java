package com.alexandelphi.leetcode.easy;

public class SplitAStringInBalancedStrings {

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Split a String in Balanced Strings.
  // Memory Usage: 38.5 MB, less than 100.00% of Java online submissions for Split a String in Balanced Strings
  // counting solution
  public int balancedStringSplit(String s) {
    int count = 0;
    int result = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'L') {
        count++;
      } else {
        count--;
      }
      if (count == 0) {
        result++;
      }
    }
    return result;
  }
}
