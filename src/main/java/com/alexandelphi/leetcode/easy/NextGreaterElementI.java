package com.alexandelphi.leetcode.easy;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElementI {

  // Runtime: 4 ms, faster than 28.65% of Java online submissions for Next Greater Element I.
  // Memory Usage: 37.6 MB, less than 96.30% of Java online submissions for Next Greater Element I.
  // brute force approach
   public int[] nextGreaterElement(int[] nums1, int[] nums2) {
     int[] result = new int[nums1.length];
     Arrays.fill(result, -1);
     for (int i = 0; i < nums1.length; i++) {
       for (int j = 0; j < nums2.length; j++) {
         if (nums2[j] == nums1[i]) {
           for (int k = j + 1; k < nums2.length; k++) {
             if (nums2[k] > nums2[j]) {
               result[i] = nums2[k];
               break;
             }
           }
         }
       }
     }
     return result;
   }

  // Runtime: 3 ms, faster than 80.92% of Java online submissions for Next Greater Element I.
  // Memory Usage: 37 MB, less than 100.00% of Java online submissions for Next Greater Element I.
  public int[] nextGreaterElementV2(int[] nums1, int[] nums2) {
    int n = nums1.length;
    int[] result = new int[n];
    Deque<Integer> stack = new ArrayDeque<>();
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums2) {
      while (!stack.isEmpty() && num > stack.peek()) {
        map.put(stack.pop(), num);
      }
      stack.push(num);
    }
    for (int i = 0; i < n; i++) {
      result[i] = map.getOrDefault(nums1[i], -1);
    }
    return result;
  }
}
