package com.alexandelphi.leetcode.easy;

import java.util.Arrays;

public class MergeSortedArray {

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Sorted Array.
  // Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for Merge Sorted Array.
  // my easy and straightforward solution with Time O(nlog(n)), Space O(1) complexity
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    for (int i = m; i < nums1.length; i++) {
      nums1[i] = nums2[i - m];
    }
    Arrays.sort(nums1);
  }
}
