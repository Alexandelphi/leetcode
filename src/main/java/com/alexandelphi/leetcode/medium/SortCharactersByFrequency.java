package com.alexandelphi.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {

  // Runtime: 21 ms, faster than 30.19% of Java online submissions for Sort Characters By Frequency.
  // Memory Usage: 38.4 MB, less than 92.59% of Java online submissions for Sort Characters By Frequency.
  // O(n*log(m)) solution, where 'm' is count of characters, for only a-z m = 26
  public String frequencySort(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
    }
    PriorityQueue<Map.Entry<Character, Integer>> pq =
        new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
    pq.addAll(map.entrySet());
    StringBuilder sb = new StringBuilder();
    while (!pq.isEmpty()) {
      Map.Entry<Character, Integer> entry = pq.poll();
      for (int i = 0; i < entry.getValue(); i++) {
        sb.append(entry.getKey());
      }
    }
    return sb.toString();
  }
}
