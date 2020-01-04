package com.alexandelphi.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

  // Runtime: 5 ms, faster than 48.93% of Java online submissions for Combination Sum.
  // Memory Usage: 37.7 MB, less than 100.00% of Java online submissions for Combination Sum.
  // my backtracking solution
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(candidates, target, result, new ArrayList<>(), 0, 0);
    return result;
  }

  private void backtrack(int[] candidates, int target, List<List<Integer>> result,
                         List<Integer> list, int index, int sum) {
    if (target == sum) {
      result.add(new ArrayList<>(list));
    }
    for (int i = index; i < candidates.length && sum < target; i++) {
      int value = candidates[i];
      list.add(value);
      // Note: we have to pass "i" as "index" to next backtrack call in order to remove duplicates!!!
      backtrack(candidates, target, result, list, i, sum + value);
      list.remove(list.size() - 1);
    }
  }

  // Runtime: 5 ms, faster than 48.93% of Java online submissions for Combination Sum.
  // Memory Usage: 37.5 MB, less than 100.00% of Java online submissions for Combination Sum.
  // second version
  public List<List<Integer>> combinationSumV2(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(candidates, target, result, new ArrayList<>(), 0);
    return result;
  }

  private void backtrack(int[] candidates, int remain, List<List<Integer>> result,
                         List<Integer> list, int index) {
    if (remain < 0) {
      return;
    } else if (remain == 0) {
      result.add(new ArrayList<>(list));
    } else {
      for (int i = index; i < candidates.length; i++) {
        list.add(candidates[i]);
        // Note: we have to pass "i" as "index" to next backtrack call in order to remove duplicates!!!
        backtrack(candidates, remain - candidates[i], result, list, i);
        list.remove(list.size() - 1);
      }
    }
  }

  public static void main(String[] args) {
    System.out.println(new CombinationSum().combinationSum(new int[] {2,3,5}, 8));
  }
}
