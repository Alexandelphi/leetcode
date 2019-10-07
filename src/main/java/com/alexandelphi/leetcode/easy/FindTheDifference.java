package com.alexandelphi.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class FindTheDifference {
  // my naive version
  public char findTheDifference(String s, String t) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    for (char c : t.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) - 1);
    }
    for (char c : map.keySet()) {
      if (map.get(c) < 0) {
        return c;
      }
    }
    return '?';
  }

  // improved version
  public char findTheDifferenceV2(String s, String t) {
    int s1 = 0;
    int s2 = 0;
    for (char c : s.toCharArray()) {
      s1 += (int) c;
    }
    for (char c : t.toCharArray()) {
      s2 += (int) c;
    }
    return (char) (s2 - s1);
  }
}
