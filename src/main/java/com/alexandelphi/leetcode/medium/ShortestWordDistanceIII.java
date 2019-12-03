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
  public int shortestWordDistance1(String[] words, String word1, String word2) {
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

  // Runtime: 2 ms, faster than 54.29% of Java online submissions for Shortest Word Distance III.
  // Memory Usage: 36.6 MB, less than 100.00% of Java online submissions for Shortest Word Distance III.
  // my 2nd solution
  public int shortestWordDistance2(String[] words, String word1, String word2) {
    int index1 = -1;
    int index2 = -1;
    int result = Integer.MAX_VALUE;
    boolean shouldChange = true;
    for (int i = 0; i < words.length; i++) {
      if (!word1.equals(word2)) {
        if (words[i].equals(word1)) index1 = i;
        if (words[i].equals(word2)) index2 = i;
      } else {
        if (words[i].equals(word1) && shouldChange) {
          index1 = i;
          shouldChange = false;
        } else if (words[i].equals(word2)) {
          index2 = i;
          shouldChange = true;
        }
      }

      if (index1 != -1 && index2 != -1) {
        result = Math.min(result, Math.abs(index2 - index1));
      }
    }
    return result;
  }
}
