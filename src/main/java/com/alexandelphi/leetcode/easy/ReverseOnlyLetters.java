package com.alexandelphi.leetcode.easy;

public class ReverseOnlyLetters {

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Only Letters.
  // Memory Usage: 37 MB, less than 8.70% of Java online submissions for Reverse Only Letters.
  // two pointers solution
  public String reverseOnlyLetters(String s) {
    char[] str = s.toCharArray();
    int i = 0;
    int j = str.length - 1;
    while (i < j) {
      if(!isCharacter(str[i])) {
        i++;
        continue;
      }
      if(!isCharacter(str[j])) {
        j--;
        continue;
      }
      swap(str, i, j);
      i++;
      j--;
    }
    return new String(str);
  }

  private boolean isCharacter(char ch) {
    return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
  }

  private void swap(char[] arr, int i, int j) {
    char tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}
