package com.alexandelphi.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//  Runtime: 28 ms, faster than 83.06% of Java online submissions for Shortest Word Distance II.
//  Memory Usage: 45.9 MB, less than 92.00% of Java online submissions for Shortest Word Distance II.

public class ShortestWordDistanceII {
  private Map<String, List<Integer>> wordList;

  public ShortestWordDistanceII(String[] words) {
    wordList = new HashMap<>();
    for (int i = 0; i < words.length; i++) {
      if (wordList.containsKey(words[i])) {
        List<Integer> indices = new ArrayList<>(wordList.get(words[i]));
        indices.add(i + 1);
        wordList.put(words[i], indices);
      } else {
        wordList.put(words[i], Arrays.asList(i + 1));
      }
    }
  }

  public int shortest(String word1, String word2) {
    List<Integer> w1 = wordList.get(word1);
    List<Integer> w2 = wordList.get(word2);
    int result = Integer.MAX_VALUE;
    for (int i : w1) {
      for (int j : w2) {
        result = Math.min(result, Math.abs(i - j));
      }
    }
    return result;
  }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */