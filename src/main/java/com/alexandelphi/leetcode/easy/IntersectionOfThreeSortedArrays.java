package com.alexandelphi.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfThreeSortedArrays {

  // my easy and straightforward solution, but not so efficient
  public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> result = new ArrayList<>();
    for (int i : arr1) map.put(i, map.getOrDefault(i, 0) + 1);
    for (int i : arr2) map.put(i, map.getOrDefault(i, 0) + 1);
    for (int i : arr3) map.put(i, map.getOrDefault(i, 0) + 1);
    for (int i : map.keySet()) {
      if (map.get(i) == 3) {
        result.add(i);
      }
    }
    return result;
  }

  // Runtime: 2 ms, faster than 78.74% of Java online submissions for Intersection of Three Sorted Arrays.
  // Memory Usage: 39.1 MB, less than 100.00% of Java online submissions for Intersection of Three Sorted Arrays.
  // improved version
  public List<Integer> arraysIntersectionV2(int[] arr1, int[] arr2, int[] arr3) {
    List<Integer> result = new ArrayList<>();
    int i = 0;
    int j = 0;
    int k = 0;
    while (i < arr1.length && j < arr2.length && k < arr3.length) {
      if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
        result.add(arr1[i]);
        i++;
        j++;
        k++;
      } else if (arr1[i] < arr2[j]) {
        i++;
      } else if (arr2[j] < arr3[k]) {
        j++;
      } else {
        k++;
      }
    }
    return result;
  }
}
