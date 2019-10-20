package com.alexandelphi.leetcode.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

  //  Runtime: 2 ms, faster than 88.83% of Java online submissions for Kth Largest Element in an Array.
  //  Memory Usage: 38.1 MB, less than 51.30% of Java online submissions for Kth Largest Element in an Array.

  //  my solution with using sorting
  public int findKthLargestV2(int[] nums, int k) {
    if (k < 0) {
      return -1;
    }
    Arrays.sort(nums);
    return nums[nums.length - k];
  }

  // my solution with using HeapSort (PriorityQueue)
  public int findKthLargestV1(int[] nums, int k) {
    PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
    for (int i : nums) {
      heap.add(i);
    }
    int result = -1;
    for (int i = 0; i < k; i++) {
      result = heap.remove();
    }
    return result;
  }
}
