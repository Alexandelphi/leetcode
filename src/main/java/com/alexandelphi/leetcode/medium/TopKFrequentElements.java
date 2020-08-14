package com.alexandelphi.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

  // Runtime: 10 ms, faster than 83.61% of Java online submissions for Top K Frequent Elements.
  // Memory Usage: 42.1 MB, less than 78.60% of Java online submissions for Top K Frequent Elements.
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int val : nums) {
      map.put(val, map.getOrDefault(val, 0) + 1);
    }
    PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
        (a, b) -> a.getValue() != b.getValue() ? a.getValue() - b.getValue() : b.getKey() - a.getKey()
    );
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      pq.add(entry);
      if (pq.size() > k) {
        pq.remove();
      }
    }
    int[] result = new int[k];
    while (k-- > 0) {
      result[k] = pq.remove().getKey();
    }
    return result;
  }
}
