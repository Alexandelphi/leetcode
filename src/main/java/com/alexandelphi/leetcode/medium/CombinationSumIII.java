package com.alexandelphi.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {


  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Combination Sum III.
  // Memory Usage: 33.7 MB, less than 8.00% of Java online submissions for Combination Sum III.
  // Finally I can cope with backtracking tasks in normal way!!! :-)
  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(result, new ArrayList<>(), k, n, 1);
    return result;
  }

  private void backtrack(List<List<Integer>> result, List<Integer> list, int k, int n, int index) {
    if (n < 0) {
      return;
    } else if (list.size() == k && n == 0) {
      result.add(new ArrayList<>(list));
    } else {
      for (int i = index; i <= 9 && list.size() < k; i++) {
        list.add(i);
        backtrack(result, list, k, n - i, i + 1);
        list.remove(list.size() - 1);
      }
    }
  }
}
