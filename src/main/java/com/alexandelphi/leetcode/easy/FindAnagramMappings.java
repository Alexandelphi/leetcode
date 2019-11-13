package com.alexandelphi.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class FindAnagramMappings {

  // Runtime: 1 ms, faster than 98.62% of Java online submissions for Find Anagram Mappings.
  // Memory Usage: 35.9 MB, less than 92.31% of Java online submissions for Find Anagram Mappings.

  public int[] anagramMappings(int[] A, int[] B) {
    int n = A.length;
    int[] result = new int[n];
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < n; i++) {
      map.put(B[i], i);
    }

    for (int i = 0; i < n; i++) {
      result[i] = map.get(A[i]);
    }
    return result;
  }
}
