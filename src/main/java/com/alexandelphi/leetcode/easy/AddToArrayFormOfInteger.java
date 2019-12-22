package com.alexandelphi.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddToArrayFormOfInteger {
  // Runtime: 5 ms, faster than 85.66% of Java online submissions for Add to Array-Form of Integer.
  // Memory Usage: 40.8 MB, less than 100.00% of Java online submissions for Add to Array-Form of Integer.
  public List<Integer> addToArrayForm(int[] a, int k) {
    List<Integer> result = new ArrayList<>();
    for (int i = a.length - 1; i >= 0; i--) {
      result.add((a[i] + k) % 10);
      k = (a[i] + k) / 10;
    }
    while (k > 0) {
      result.add(k % 10);
      k = k / 10;
    }
    Collections.reverse(result);
    return result;
  }
}
