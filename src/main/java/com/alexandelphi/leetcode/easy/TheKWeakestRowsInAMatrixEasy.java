package com.alexandelphi.leetcode.easy;

import java.util.PriorityQueue;

import javafx.util.Pair;

public class TheKWeakestRowsInAMatrixEasy {


  // Runtime: 3 ms, faster than 51.02% of Java online submissions for The K Weakest Rows in a Matrix.
  // Memory Usage: 40.5 MB, less than 72.06% of Java online submissions for The K Weakest Rows in a Matrix.

  public int[] kWeakestRows(int[][] mat, int k) {
    PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(
        (a, b) -> a.getValue() != b.getValue() ? a.getValue() - b.getValue() : a.getKey() - b.getKey()
    );
    for (int r = 0; r < mat.length; r++) {
      int count = 0;
      for (int c = 0; c < mat[r].length; c++) { // we can use BinarySearch here as we have sorted arrays
        if (mat[r][c] == 1) {
          count++;
        }
      }
      pq.add(new Pair<>(r, count));
    }
    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
      result[i] = pq.poll().getKey();
    }
    return result;
  }
}
