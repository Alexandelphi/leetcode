package com.alexandelphi.leetcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


// Runtime: 3 ms, faster than 25.22% of Java online submissions for Lucky Numbers in a Matrix.
// Memory Usage: 40.2 MB, less than 100.00% of Java online submissions for Lucky Numbers in a Matrix.
// straightforward solution with using HashSet
public class LuckyNumbersInAMatrix {
  public List<Integer> luckyNumbers (int[][] matrix) {
    Set<Integer> minRowList = new HashSet<>();
    Set<Integer> maxColList = new HashSet<>();

    for (int row = 0; row < matrix.length; row++) {
      int min = Integer.MAX_VALUE;
      for (int col = 0; col < matrix[0].length; col++) {
        min = Math.min(min, matrix[row][col]);
      }
      minRowList.add(min);
    }
    for (int col = 0; col < matrix[0].length; col++) {
      int max = Integer.MIN_VALUE;
      for (int row = 0; row < matrix.length; row++) {
        max = Math.max(max, matrix[row][col]);
      }
      maxColList.add(max);
    }
    List<Integer> result = new ArrayList<>();
    for (int val : minRowList) {
      if (maxColList.contains(val)) {
        result.add(val);
      }
    }
    return result;
  }
}
