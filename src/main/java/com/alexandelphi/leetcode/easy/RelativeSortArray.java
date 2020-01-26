package com.alexandelphi.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class RelativeSortArray {

  // Runtime: 14 ms, faster than 5.29% of Java online submissions for Relative Sort Array.
  // Memory Usage: 39.8 MB, less than 100.00% of Java online submissions for Relative Sort Array.
  // my first solution of this problem ...
  // as I do two redundant transformation "int -> Integer" and "Integer -> int",
  // and I'll optimise the code later on
  public int[] relativeSortArray(int[] arr1, int[] arr2) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr2.length; i++) {
      map.put(arr2[i], i);
    }
    return Arrays.stream(arr1)
        .boxed()
        .sorted(Comparator.comparingInt(a -> map.get(a) != null ? map.get(a) : 1000 + a))
        .mapToInt(i -> i)
        .toArray();
  }
}
