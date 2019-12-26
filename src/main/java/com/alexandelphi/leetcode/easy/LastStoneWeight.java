package com.alexandelphi.leetcode.easy;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
  // Runtime: 1 ms, faster than 95.37% of Java online submissions for Last Stone Weight.
  // Memory Usage: 34.2 MB, less than 100.00% of Java online submissions for Last Stone Weight.
  public int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    for (int value : stones) {
      pq.add(value);
    }
    while (pq.size() > 1) {
      int y = pq.remove();
      int x = pq.remove();
      if (x != y) {
        pq.add(y - x);
      }
    }
    if (pq.size() == 1) {
      return pq.remove();
    }
    return 0;
  }
}
