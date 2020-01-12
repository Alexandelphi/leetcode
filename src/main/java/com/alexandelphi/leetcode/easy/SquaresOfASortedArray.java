package com.alexandelphi.leetcode.easy;

import java.util.Arrays;

public class SquaresOfASortedArray {

  // Runtime: 1 ms, faster than 29.43% of Java online submissions for Squares of a Sorted Array.
  // Memory Usage: 40.5 MB, less than 100.00% of Java online submissions for Squares of a Sorted Array.
  // naive solution
  public int[] sortedSquares(int[] A) {
    for (int i = 0; i < A.length; i++) {
      A[i] = (int) Math.pow(A[i], 2);
    }
    Arrays.sort(A);
    return A;
  }


  // Runtime: 1 ms, faster than 100.00% of Java online submissions for Squares of a Sorted Array.
  // Memory Usage: 41.3 MB, less than 95.73% of Java online submissions for Squares of a Sorted Array.
  // optimal solution
  public int[] sortedSquaresV2(int[] arr) {
    int n = arr.length;
    int[] newArr = new int[arr.length];
    int i = 0, j = n - 1;
    for (int k = n - 1; k >= 0; k--) {
      if (Math.abs(arr[i]) > Math.abs(arr[j])) {
        newArr[k] = arr[i] * arr[i];
        i++;
      } else {
        newArr[k] = arr[j] * arr[j];
        j--;
      }
    }
    return newArr;
  }
}
