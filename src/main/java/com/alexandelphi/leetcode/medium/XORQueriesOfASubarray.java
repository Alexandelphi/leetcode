package com.alexandelphi.leetcode.medium;

public class XORQueriesOfASubarray {


  // Runtime: 1217 ms, faster than 5.05% of Java online submissions for XOR Queries of a Subarray.
  // Memory Usage: 54.5 MB, less than 100.00% of Java online submissions for XOR Queries of a Subarray.
  // my straightforward solution
  public int[] xorQueries(int[] arr, int[][] queries) {
    int n = queries.length;
    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
      int begin = queries[i][0];
      int end =  queries[i][1];

      result[i] = arr[begin];
      for (int j = begin + 1; j <= end; j++) {
        result[i] ^= arr[j];
      }
    }
    return result;
  }

  // Runtime: 1 ms, faster than 100.00% of Java online submissions for XOR Queries of a Subarray.
  // Memory Usage: 54.5 MB, less than 100.00% of Java online submissions for XOR Queries of a Subarray.
  // we can use prefix sum algorithm as XOR has the following behavior
  // if you have: c = a^b
  // You can get 'a' or 'b' back if you have the other value available:
  // a = c^b; // or b^c (order is not important)
  // b = c^a; // or a^c

  public int[] xorQueriesV2(int[] arr, int[][] queries) {
    int[] result = new int[queries.length];
    for (int i = 1; i < arr.length; i++) {
      arr[i] ^= arr[i - 1];
    }
    for (int i = 0; i < queries.length; i++) {
      int begin = queries[i][0];
      int end = queries[i][1];
      if (begin == 0) {
        result[i] = arr[end];
      } else {
        result[i] = arr[begin - 1] ^ arr[end];
      }
    }
    return result;
  }
}
