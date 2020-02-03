package com.alexandelphi.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {

  // Runtime: 5 ms, faster than 98.73% of Java online submissions for Top K Frequent Words.
  // Memory Usage: 41.2 MB, less than 5.36% of Java online submissions for Top K Frequent Words.
  // my solution based on HashMap + PriorityQueue,
  // to be honest I had to spend some time on understanding why my comparator didn't work,
  // but it turned our that I had to just add Collections.reverse() :-)
  public List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> map = new HashMap<>();
    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }

    PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new WordsFreqComparator());
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      pq.add(entry);
      if (pq.size() > k) {
        pq.remove();
      }
    }

    List<String> result = new ArrayList<>();
    while (!pq.isEmpty()) {
      result.add(pq.poll().getKey());
    }
    Collections.reverse(result);
    return result;
  }

  private class WordsFreqComparator implements Comparator<Map.Entry<String, Integer>> {
    @Override
    public int compare(Map.Entry<String, Integer> w1, Map.Entry<String, Integer> w2) {
      if (w1.getValue().equals(w2.getValue())) {
        return w2.getKey().compareTo(w1.getKey());
      }
      return w1.getValue() - w2.getValue();
    }
  }
}
