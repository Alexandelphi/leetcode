package com.alexandelphi.leetcode.easy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HighFive {

  // Runtime: 4 ms, faster than 90.58% of Java online submissions for High Five.
  // Memory Usage: 45 MB, less than 50.00% of Java online submissions for High Five.

  public int[][] highFive(int[][] items) {
    Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
    for (int[] arr : items) {
      PriorityQueue<Integer> pq =
          map.getOrDefault(arr[0], new PriorityQueue<>(Collections.reverseOrder()));
      pq.add(arr[1]);
      map.put(arr[0], pq);
    }
    int[][] result = new int[map.size()][2];
    int index = 0;
    for (int key : map.keySet()) {
      PriorityQueue<Integer> pq = map.get(key);
      int sum = 0;
      for (int j = 0; j < 5 && !pq.isEmpty(); j++) {
        sum += pq.remove();
      }
      result[index][0] = key;
      result[index][1] = sum / 5;
      index++;
    }
    return result;
  }
}
