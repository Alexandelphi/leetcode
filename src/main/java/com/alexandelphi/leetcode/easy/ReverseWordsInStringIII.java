package com.alexandelphi.leetcode.easy;

public class ReverseWordsInStringIII {
  public String reverseWords(String s) {
    if (s == null || s.length() == 0) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    for (String word : s.split(" ")) {
      sb.append(reverseWord(word));
      sb.append(' ');
    }
    sb.deleteCharAt(s.length());
    return sb.toString();
  }

  private String reverseWord(String word) {
    StringBuilder sb = new StringBuilder();
    for (int i = word.length() - 1; i >= 0; i--) {
      sb.append(word.charAt(i));
    }
    return sb.toString();
  }
}
