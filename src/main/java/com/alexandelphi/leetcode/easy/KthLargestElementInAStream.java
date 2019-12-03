package com.alexandelphi.leetcode.easy;

import java.util.PriorityQueue;

// Runtime: 19 ms, faster than 88.05% of Java online submissions for Kth Largest Element in a Stream.
// Memory Usage: 45.1 MB, less than 96.67% of Java online submissions for Kth Largest Element in a Stream.

public class KthLargestElementInAStream {
  private PriorityQueue<Integer> pq;
  private int k;

  public KthLargestElementInAStream(int k, int[] nums) {
    pq = new PriorityQueue<>();
    this.k = k;
    for (int i : nums) {
      pq.add(i);
      if (pq.size() > k) {
        pq.remove();
      }
    }
  }

  public int add(int val) {
    pq.add(val);
    if (pq.size() > k) {
      pq.remove();
    }
    return pq.peek();
  }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */