package com.alexandelphi.leetcode.easy;

public class ReverseVowelsOfAString {
  // Runtime: 2 ms, faster than 99.55% of Java online submissions for Reverse Vowels of a String.
  // Memory Usage: 39.8 MB, less than 70.10% of Java online submissions for Reverse Vowels of a String.
  // two pointers solution

  public String reverseVowels(String s) {
    char[] text = s.toCharArray();
    int i = 0;
    int j = text.length - 1;
    while (i < j) {
      while (!foundVowel(text[i]) && i < j) i++;
      while (!foundVowel(text[j]) && i < j) j--;
      swap(text, i, j);
      i++;
      j--;
    }
    return new String(text);
  }

  private boolean foundVowel(char ch) {
    if (ch >= 'a' && ch <= 'z') {
      return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    } else {
      return ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
  }

  private void swap(char[] arr, int i, int j) {
    char tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}
