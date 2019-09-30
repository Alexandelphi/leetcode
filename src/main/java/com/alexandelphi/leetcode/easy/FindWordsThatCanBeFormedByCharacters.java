package com.alexandelphi.leetcode.easy;

import java.util.Arrays;

public class FindWordsThatCanBeFormedByCharacters {
  public int countCharacters(String[] words, String chars) {
    int[] charTable = new int[26];
    for (char c : chars.toCharArray()) {
      charTable[c - 'a']++;
    }
    int sum = 0;
    for (String word : words) {
      int i = 0;
      int[] charTableCopy = charTable.clone();
      for (char c : word.toCharArray()) {
        if (charTableCopy[c - 'a']-- > 0) {
          i++;
        } else {
          break;
        }
      }
      if (i == word.length()) {
        sum += i;
      }
    }
    return sum;
  }
}
