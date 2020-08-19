package com.alexandelphi.leetcode.easy;

import java.util.PriorityQueue;

public class MaximumProductOfTwoElementsInAnArray {

  // brute force solution
  public int maxProduct(int[] nums) {
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        max = Math.max(max, (nums[i] - 1) * (nums[j] - 1));
      }
    }
    return max;
  }

  // PriorityQueue(Heap) solution
  public int maxProductV2(int[] nums) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int val : nums) {
      pq.add(val);
      if (pq.size() > 2) {
        pq.remove();
      }
    }
    int a = pq.remove();
    int b = pq.remove();
    return (a - 1) * (b - 1);
  }

  // one pass with two maximums
  public int maxProductV3(int[] nums) {
    int m1 = 0, m2 = 0;
    for (int val : nums) {
      if (val > m1) {
        m2 = m1;
        m1 = val;
      } else {
        m2 = Math.max(m2, val);
      }
    }
    return (m1 - 1) * (m2 - 1);
  }
}
