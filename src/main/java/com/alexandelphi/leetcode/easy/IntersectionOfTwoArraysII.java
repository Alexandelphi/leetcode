package com.alexandelphi.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArraysII {

  // Runtime: 6 ms, faster than 15.01% of Java online submissions for Intersection of Two Arrays II.
  // Memory Usage: 37.9 MB, less than 41.94% of Java online submissions for Intersection of Two Arrays II.
  // my straightforward solution
  public int[] intersect(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int i = 0;
    int j = 0;
    List<Integer> list = new ArrayList<>();
    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] == nums2[j]) {
        list.add(nums1[i]);
        i++;
        j++;
      } else if (nums1[i] < nums2[j]) {
        i++;
      } else {
        j++;
      }
    }
    return list.stream().mapToInt(Integer::intValue).toArray();
  }
}
