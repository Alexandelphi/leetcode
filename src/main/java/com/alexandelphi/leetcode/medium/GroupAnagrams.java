package com.alexandelphi.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

  // Runtime: 56 ms, faster than 5.70% of Java online submissions for Group Anagrams.
  // Memory Usage: 46.9 MB, less than 8.19% of Java online submissions for Group Anagrams.
  // my straightforward idea

  public List<List<String>> groupAnagrams(String[] strs) {
    Map<Map<Character, Integer>, List<String>> globalMap = new HashMap<>();
    for (String str : strs) {
      Map<Character, Integer> charsCountMap = new HashMap<>();
      for (int i = 0; i < str.length(); i++) {
        char ch = str.charAt(i);
        charsCountMap.put(ch, charsCountMap.getOrDefault(ch, 0) + 1);
      }
      List<String> list = globalMap.getOrDefault(charsCountMap, new ArrayList<>());
      list.add(str);
      globalMap.put(charsCountMap, list);
    }
    List<List<String>> result = new ArrayList<>();
    for (Map.Entry<Map<Character, Integer>, List<String>> entry : globalMap.entrySet()) {
      result.add(entry.getValue());
    }
    return result;
  }

  // Runtime: 6 ms, faster than 96.85% of Java online submissions for Group Anagrams.
  // Memory Usage: 42.7 MB, less than 81.29% of Java online submissions for Group Anagrams.
  // optimised version
  public List<List<String>> groupAnagramsV2(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      char[] word = str.toCharArray();
      Arrays.sort(word);
      String sortedWord = new String(word);
      List<String> list = map.getOrDefault(sortedWord, new ArrayList<>());
      list.add(str);
      map.put(sortedWord, list);
    }
    return new ArrayList<>(map.values());
  }
}
