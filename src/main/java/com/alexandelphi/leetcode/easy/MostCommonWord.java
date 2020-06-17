package com.alexandelphi.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class MostCommonWord {
  // https://leetcode.com/problems/most-common-word
  // Runtime: 6 ms, faster than 82.38% of Java online submissions for Most Common Word.
  // Memory Usage: 39.2 MB, less than 90.65% of Java online submissions for Most Common Word.
  // general straightforward approach

  public String mostCommonWord(String paragraph, String[] banned) {
    Map<String, Integer> map = getWords(paragraph);
    for (String str : banned) {
      map.remove(str);
    }
    int maxCount = 0;
    String result = "";
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      if (entry.getValue() > maxCount) {
        maxCount = entry.getValue();
        result = entry.getKey();
      }
    }
    return result;
  }

  private Map<String, Integer> getWords(String paragraph) {
    Map<String, Integer> map = new HashMap<>();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < paragraph.length(); i++) {
      if ((paragraph.charAt(i) >= 'a' && paragraph.charAt(i) <= 'z') ||
          (paragraph.charAt(i) >= 'A' && paragraph.charAt(i) <= 'Z')) {
        sb.append(paragraph.charAt(i));
        if (i == paragraph.length() - 1) {
          String str = sb.toString().toLowerCase();
          map.put(str, map.getOrDefault(str, 0) + 1);
          sb.setLength(0);
        }
      } else {
        String str = sb.toString().toLowerCase();
        map.put(str, map.getOrDefault(str, 0) + 1);
        sb.setLength(0);
      }
    }
    map.remove("");
    return map;
  }
}