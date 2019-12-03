package com.alexandelphi.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistanceIII {

  // Runtime: 11 ms, faster than 5.80% of Java online submissions for Shortest Word Distance III.
  // Memory Usage: 38.7 MB, less than 10.00% of Java online submissions for Shortest Word Distance III.
  // my 1st solution
  public int shortestWordDistance(String[] words, String word1, String word2) {
    Map<String, List<Integer>> wordIndicesMap = new HashMap<>();
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      if (wordIndicesMap.containsKey(word)) {
        List<Integer> indices = new ArrayList<>(wordIndicesMap.get(word));
        indices.add(i);
        wordIndicesMap.put(word, indices);
      } else {
        wordIndicesMap.put(word, Arrays.asList(i));
      }
    }
    int minDistance = Integer.MAX_VALUE;
    if (word1.equals(word2)) {
      List<Integer> indices = wordIndicesMap.get(word1);
      for (int i = 0; i < indices.size() - 1; i++) {
        int distance = Math.abs(indices.get(i) - indices.get(i + 1));
        minDistance = Math.min(minDistance, distance);
      }
    } else {
      List<Integer> word1Indices = wordIndicesMap.get(word1);
      List<Integer> word2Indices = wordIndicesMap.get(word2);
      for (int i : word1Indices) {
        for (int j : word2Indices) {
          minDistance = Math.min(minDistance, Math.abs(j - i));
        }
      }
    }
    return minDistance;
  }
}
