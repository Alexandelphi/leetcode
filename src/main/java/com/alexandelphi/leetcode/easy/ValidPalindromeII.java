package com.alexandelphi.leetcode.easy;

public class ValidPalindromeII {
  public boolean validPalindrome(String s) {
    int begin = 0;
    int end = s.length() - 1;
    while (begin < end) {
      if (s.charAt(begin) != s.charAt(end)) {
        return isPalindrome(s, begin + 1, end) || isPalindrome(s, begin, end - 1);
      }
      begin++;
      end--;
    }
    return true;
  }

  private boolean isPalindrome(String s, int begin, int end) {
    while (begin < end) {
      if (s.charAt(begin) != s.charAt(end)) {
        return false;
      }
      begin++;
      end--;
    }
    return true;
  }
}
