package com.alexandelphi.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// my straightforward solution

public class MinimumAbsoluteDifference {
  public List<List<Integer>> minimumAbsDifference(int[] arr) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(arr);
    int minDistance = fineMinDistance(arr);
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] - arr[i - 1] == minDistance) {
        list.add(Arrays.asList(arr[i - 1], arr[i]));
      }
    }
    return list;
  }

  private int fineMinDistance(int[] sortedArr) {
    int min = Integer.MAX_VALUE;
    for (int i = 1; i < sortedArr.length; i++) {
      min = Math.min(min, sortedArr[i] - sortedArr[i - 1]);
    }
    return min;
  }
}
