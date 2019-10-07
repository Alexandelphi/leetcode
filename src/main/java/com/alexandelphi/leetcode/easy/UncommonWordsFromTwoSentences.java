package com.alexandelphi.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// 1) my straightforward solution, need to think if I can do better
public class UncommonWordsFromTwoSentences {
  public String[] uncommonFromSentences(String A, String B) {
    Map<String, Integer> mapForA = getParsedSentence(A);
    Map<String, Integer> mapForB = getParsedSentence(B);
    List<String> arr = new ArrayList<>();
    for (String word : mapForA.keySet()) {
      if (mapForA.containsKey(word) && mapForA.get(word) == 1) {
        if (!mapForB.containsKey(word)) {
          arr.add(word);
        }
      }
    }
    for (String word : mapForB.keySet()) {
      if (mapForB.containsKey(word) && mapForB.get(word) == 1) {
        if (!mapForA.containsKey(word)) {
          arr.add(word);
        }
      }
    }
    return arr.toArray(new String[arr.size()]);
  }

  private Map<String, Integer> getParsedSentence(String str) {
    Map<String, Integer> wordsMap = new HashMap<>();
    for (String word : str.split(" ")) {
      wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
    }
    return wordsMap;
  }

  // 2) less code, but the same performance result, slightly better
  public String[] uncommonFromSentencesV2(String A, String B) {
    Map<String, Integer> count = new HashMap<>();

    for (String word : A.split(" ")) {
      count.put(word, count.getOrDefault(word, 0) + 1);
    }
    for (String word : B.split(" ")) {
      count.put(word, count.getOrDefault(word, 0) + 1);
    }

    List<String> arr = new ArrayList<>();
    for (String word : count.keySet()) {
      if (count.get(word) == 1) {
        arr.add(word);
      }
    }
    return arr.toArray(new String[arr.size()]);
  }
}
