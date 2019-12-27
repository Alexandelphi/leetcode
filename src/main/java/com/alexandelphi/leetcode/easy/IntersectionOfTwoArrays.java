package com.alexandelphi.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
  // Runtime: 6 ms, faster than 13.77% of Java online submissions for Intersection of Two Arrays.
  // Memory Usage: 37.9 MB, less than 40.54% of Java online submissions for Intersection of Two Arrays.
  public int[] intersection(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int i = 0;
    int j = 0;
    Set<Integer> list = new HashSet<>();
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
