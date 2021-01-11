package com.alexandelphi.leetcode.medium;

public class ReverseWordsInAStringII {
  // Runtime: 1 ms, faster than 99.45% of Java online submissions for Reverse Words in a String II.
  // Memory Usage: 51.7 MB, less than 5.53% of Java online submissions for Reverse Words in a String II.
  // Time (n), Space (1)
  public void reverseWords(char[] s) {
    reverse(s, 0, s.length - 1);
    int i = 0;
    int j = 0;
    while (j < s.length) {
      if (s[j] != ' ') {
        j++;
      } else {
        reverse(s, i, j - 1);
        j++;
        i = j;
      }
    }
    reverse(s, i, j - 1);
  }

  private void reverse(char[] s, int i, int j) {
    while (i < j) {
      char tmp = s[i];
      s[i] = s[j];
      s[j] = tmp;
      i++;
      j--;
    }
  }
}
