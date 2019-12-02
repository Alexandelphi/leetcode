package com.alexandelphi.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
  //  Runtime: 1 ms, faster than 99.26% of Java online submissions for Word Pattern.
  //  Memory Usage: 34 MB, less than 97.30% of Java online submissions for Word Pattern.
  //  my solution which is based on "Isomorphic Strings" solution
  public boolean wordPattern(String pattern, String str) {
    if (pattern == null || str == null) {
      return false;
    }
    String[] words = str.split(" ");
    if (pattern.length() != words.length) {
      return false;
    }
    Map<Character, Integer> charsMap = new HashMap<>();
    Map<String, Integer> wordsMap = new HashMap<>();
    for (int i = 0; i < pattern.length(); i++) {
      int indexOfChar = charsMap.getOrDefault(pattern.charAt(i), -1);
      int indexOfWord = wordsMap.getOrDefault(words[i], -1);
      if (indexOfChar != indexOfWord) {
        return false;
      }
      charsMap.put(pattern.charAt(i), i);
      wordsMap.put(words[i], i);
    }
    return true;
  }
}
