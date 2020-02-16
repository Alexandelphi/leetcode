package com.alexandelphi.leetcode.medium;

public class LongestPalindromicSubstring {

  // Runtime: 29 ms, faster than 49.90% of Java online submissions for Longest Palindromic Substring.
  // Memory Usage: 41.5 MB, less than 7.26% of Java online submissions for Longest Palindromic Substring.
  // my clean and concise solution, version 1
  String maxStr = "";
  public String longestPalindrome(String s) {
    if (s.length() == 0 || s.length() == 1) {
      return s;
    }
    for (int i = 0; i < s.length(); i++) {
      isPalindomic(s, i, true);
      isPalindomic(s, i, false);
    }
    return maxStr;
  }

  private void isPalindomic(String s, int index, boolean hasMiddle) {
    int i = index;
    int j = hasMiddle ? index : index + 1;
    while (i >= 0 && j < s.length()) {
      if (s.charAt(i) == s.charAt(j)) {
        if (maxStr.length() <= j - i) {
          maxStr =  s.substring(i, j + 1);
        }
      } else {
        return;
      }
      i--;
      j++;
    }
  }
}


class LongestPalindromicSubstringV2 {
  // Runtime: 24 ms, faster than 58.61% of Java online submissions for Longest Palindromic Substring.
  // Memory Usage: 37.4 MB, less than 80.65% of Java online submissions for Longest Palindromic Substring.
  // my clean and concise solution, version 2
  // Significantly improved space complexity!

  private int left;
  private int right;

  public String longestPalindrome(String s) {
    if (s.length() == 0 || s.length() == 1) {
      return s;
    }
    for (int i = 0; i < s.length(); i++) {
      isPalindomic(s, i, true);
      isPalindomic(s, i, false);
    }
    return s.substring(left, right);
  }

  private void isPalindomic(String s, int index, boolean hasMiddle) {
    int i = index;
    int j = hasMiddle ? index : index + 1;
    while (i >= 0 && j < s.length()) {
      if (s.charAt(i) == s.charAt(j)) {
        if (right - left <= j - i) {
          left = i;
          right = j + 1;
        }
      } else {
        return;
      }
      i--;
      j++;
    }
  }
}

class LongestPalindromicSubstringV3 {
  // The best solution is Manacher's Algorithm with linear time complexity :-)
  // I don't this algorithm yet, but as soon as I learn it, I'll add another solution here
}
