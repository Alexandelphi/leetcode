package com.alexandelphi.leetcode.easy;

public class ArmstrongNumber {

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Armstrong Number.
  // Memory Usage: 36 MB, less than 91.67% of Java online submissions for Armstrong Number.

  public boolean isArmstrong(int N) {
    int n = N;
    int k = 0;
    int sum = 0;
    while (n != 0) { // can be done with "Math.log10(N) + 1"
      k++;
      n = n / 10;
    }
    n = N;
    while (n != 0) {
      int digit = n % 10;
      sum += Math.pow(digit, k);
      n = n / 10;
    }
    return N == sum;
  }
}
