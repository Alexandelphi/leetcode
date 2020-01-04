package com.alexandelphi.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

  // Runtime: 9 ms, faster than 78.61% of Java online submissions for Combinations.
  // Memory Usage: 40 MB, less than 71.74% of Java online submissions for Combinations.
  // my backtracking solution
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> result = new ArrayList<>();
    helper(result, new ArrayList<>(), n, k, 1);
    return result;
  }

  private void helper(List<List<Integer>> result, List<Integer> list, int n, int k, int index) {
    if (list.size() == k) {
      result.add(new ArrayList<>(list));
    }
    for (int i = index; i <= n; i++) {
      list.add(i);
      helper(result, list, n, k, i + 1);
      list.remove(list.size() - 1);
    }
  }
}
