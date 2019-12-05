package com.alexandelphi.leetcode.easy;

public class LongestCommonPrefix {
  // Runtime: 1 ms, faster than 74.38% of Java online submissions for Longest Common Prefix.
  // Memory Usage: 38.1 MB, less than 80.70% of Java online submissions for Longest Common Prefix.
  public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }
    if (strs.length == 1) {
      return strs[0];
    }
    char[] mainWord = strs[0].toCharArray();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < mainWord.length; i++) {
      for (int j = 1; j < strs.length; j++) {
        String word = strs[j];
        if (i >= word.length()) {
          return sb.toString();
        } else if (mainWord[i] != word.charAt(i)) {
          return sb.toString();
        }
      }
      sb.append(mainWord[i]);
    }
    return sb.toString();
  }
}
