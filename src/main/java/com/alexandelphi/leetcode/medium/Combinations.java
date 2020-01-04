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
    // theoretically if use "i <= n && list.size() < k" it should improve the performance,
    // because we will remove redundant backtrack steps, but
    // the result is "Runtime: 34 ms, faster than 17.24% and Memory Usage: 41.9 MB, less than 8.70%"
    // when I tried ... as for now, I left it as is and it will be investigated
    for (int i = index; i <= n; i++) {
      list.add(i);
      helper(result, list, n, k, i + 1);
      list.remove(list.size() - 1);
    }
  }
}
