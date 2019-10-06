package com.alexandelphi.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
  public List<Integer> selfDividingNumbers(int left, int right) {
    List<Integer> result = new ArrayList<>();
    for (int i = left; i <= right; i++) {
      if (checkSelfDividing(i)) {
        result.add(i);
      }
    }
    return result;
  }

  private boolean checkSelfDividing(int n) {
    int copyNum = n;
    while (copyNum > 0) {
      int digit = copyNum % 10;
      if ((digit == 0) || (n % digit != 0)) {
        return false;
      }
      copyNum /= 10;
    }
    return true;
  }
}
