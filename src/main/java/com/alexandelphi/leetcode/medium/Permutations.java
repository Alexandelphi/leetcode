package com.alexandelphi.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {

  // my first solution - not optimized
  private List<List<Integer>> map = new ArrayList<>();
  public List<List<Integer>> permuteV1(int[] nums) {
    boolean[] used = new boolean[nums.length];
    int[] result = new int[nums.length];
    permuteAllV1(nums, used, result, 0);
    return map;
  }

  private void permuteAllV1(int[] nums, boolean[] used, int[] result, int level) {
    if (level == nums.length) {
      map.add(Arrays.stream(result).boxed().collect(Collectors.toList()));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (used[i] == true) {
        continue;
      }
      result[level] = nums[i];
      used[i] = true;
      permuteAllV1(nums, used, result, level + 1);
      used[i] = false;
    }
  }

  // Runtime: 1 ms, faster than 98.06% of Java online submissions for Permutations.
  // Memory Usage: 36.3 MB, less than 98.58% of Java online submissions for Permutations
  // optimised version
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    permuteAll(nums, new ArrayList<Integer>(), result);
    return result;
  }

  private void permuteAll(int[] nums, List<Integer> list, List<List<Integer>> result) {
    if (list.size() == nums.length) {
      result.add(new ArrayList(list));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (list.contains(nums[i])) continue;
      list.add(nums[i]);
      permuteAll(nums, list, result);
      list.remove(list.size() - 1);
    }
  }


}
