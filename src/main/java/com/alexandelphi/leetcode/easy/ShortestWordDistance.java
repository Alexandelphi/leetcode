package com.alexandelphi.leetcode.easy;

public class ShortestWordDistance {

  // Runtime: 2 ms, faster than 49.97% of Java online submissions for Shortest Word Distance.
  // Memory Usage: 36 MB, less than 100.00% of Java online submissions for Shortest Word Distance.

  public int shortestDistance(String[] words, String word1, String word2) {
    int wordCount = 0;
    int word1Index = -1;
    int word2Index = -1;
    int result = Integer.MAX_VALUE;
    for (String word : words) {
      wordCount++;
      if (word.equals(word1)) {
        word1Index = wordCount;
      }
      if (word.equals(word2)) {
        word2Index = wordCount;
      }
      if (word1Index != -1 && word2Index != -1) {
        result = Math.min(result, Math.abs(word1Index - word2Index));
      }
    }
    return result;
  }
}
