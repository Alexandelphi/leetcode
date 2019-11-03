package com.alexandelphi.leetcode.medium;

import java.util.ArrayList;
import java.util.List;


// Runtime: 0 ms, faster than 100.00% of Java online submissions for Subsets.
// Memory Usage: 37.3 MB, less than 99.18% of Java online submissions for Subsets.

public class Subsets {
  public static List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(nums, new ArrayList<>(), result, 0);
    return result;
  }

  private static void backtrack(int[] nums, List<Integer> list, List<List<Integer>> result, int level) {
    result.add(new ArrayList<>(list));
    for (int i = level; i < nums.length; i++) {
      list.add(nums[i]);
      backtrack(nums, list, result, i + 1);
      list.remove(list.size() - 1);
    }
  }

  public static void main(String[] args) {
    int[] arr = new int[]{1, 2, 3};
    System.out.println(subsets(arr));
  }
}
