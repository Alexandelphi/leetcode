package com.alexandelphi.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences {

  // Runtime: 2 ms, faster than 88.57% of Java online submissions for Unique Number of Occurrences.
  // Memory Usage: 35.5 MB, less than 100.00% of Java online submissions for Unique Number of Occurrences.
  // my straightforward solution
  public boolean uniqueOccurrences(int[] arr) {
    Map<Integer, Integer> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < arr.length; i++) {
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    }
    for (int key : map.keySet()) {
      set.add(map.get(key));
    }
    return map.size() == set.size();
  }
}
