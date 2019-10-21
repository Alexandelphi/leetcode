package com.alexandelphi.leetcode.easy;

import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class ThirdMaximumNumber {

  // Runtime: 6 ms, faster than 23.36% of Java online submissions for Third Maximum Number.
  // Memory Usage: 38.4 MB, less than 91.30% of Java online submissions for Third Maximum Number

  // my straightforward solution - Time Complexity (n), Space (n)
  public int thirdMax(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    Set<Integer> set = new HashSet<>();
    for (int i : nums) {
      if (!set.contains(i)) {
        pq.add(i);
        set.add(i);
      }
    }
    int result = -1;
    int n = 3;
    if (pq.size() < n) {
      n = 1;
    }
    for (int i = 0; i < n; i++) {
      result = pq.remove();
    }
    return result;
  }

  // another version of pretty the same solution, but with Time (n) and Space (1)
  public int thirdMax2(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    Set<Integer> set = new HashSet<>();
    for (int i : nums) {
      if (!set.contains(i)) {
        pq.add(i);
        set.add(i);
        if (pq.size() > 3) {
          set.remove(pq.remove());
        }
      }
    }

    if (pq.size() < 3) {
      while (pq.size() > 1) {
        pq.remove();
      }
    }

    return pq.remove();
  }
}
