package com.alexandelphi.leetcode.easy;

public class ConsecutiveCharacters {
  //  Runtime: 1 ms, faster than 100.00% of Java online submissions for Consecutive Characters.
  //  Memory Usage: 39.5 MB, less than 43.33% of Java online submissions for Consecutive Characters.
  public int maxPower(String s) {
    int max = 0;
    char prev = s.charAt(0);
    int length = 0;
    for (char ch : s.toCharArray()) {
      if (prev != ch) {
        prev = ch;
        max = Math.max(max, length);
        length = 1;
      } else {
        length++;
      }
    }
    max = Math.max(max, length);
    return max;
  }
}
