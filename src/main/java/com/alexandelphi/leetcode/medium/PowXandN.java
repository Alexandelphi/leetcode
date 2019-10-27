package com.alexandelphi.leetcode.medium;

public class PowXandN {
  public double myPow(double x, int n) {
    if (n == 0) return 1;
    double i = 0.0;
    if (n > 0) {
      i = myPow(x, n / 2);
      return n % 2 == 0 ? i * i : i * i * x;
    } else {
      i = myPow(1 / x, -(n / 2));
      return n % 2 == 0 ? i * i : i * i * 1 / x;
    }
  }
}
