package com.alexandelphi.leetcode.easy;

public class ValidPalindrome {
  // Task Definition
  // Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
  // Note: For the purpose of this problem, we define empty string as valid palindrome.

  // Runtime: 3 ms, faster than 96.42% of Java online submissions for Valid Palindrome.
  // Memory Usage: 42.6 MB, less than 5.35% of Java online submissions for Valid Palindrome.
  // my solution which came to mind almost immediately, but I couldn't know that
  // a string with "@!$*!@^$*(" means empty as well and it's valid .... failed a few times because of it
  // anyway it's a cool task and I really liked it :-)
  public boolean isPalindrome(String s) {
    char[] str = s.toCharArray();
    int i = 0;
    int j = str.length - 1;
    while (i <= j) {
      char ch1 = str[i];
      char ch2 = str[j];
      if (charCheck(ch1)) {
        ch1 = Character.toLowerCase(ch1);
      } else {
        i++;
        continue;
      }
      if (charCheck(ch2)) {
        ch2 = Character.toLowerCase(ch2);
      } else {
        j--;
        continue;
      }
      if (ch1 != ch2) {
        return false;
      } else {
        i++;
        j--;
      }
    }
    return true;
  }

  private boolean charCheck(char ch) {
    if ((ch >= 'a' && ch <= 'z' ) || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) {
      return true;
    } else {
      return false;
    }
  }
}
