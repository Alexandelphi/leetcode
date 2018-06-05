package com.alexandelphi.leetcode;

public class ReverseInteger {

  public int reverse(int x) {
    long result = 0;
    while (true) {
      result = result * 10 + x % 10;
      x = x / 10;
      if (x == 0) {
        break;
      }
    }
    try {
      return Integer.valueOf(Long.toString(result));
    } catch (Exception e) {
      return 0;
    }
  }

  public static void main(String[] args) {
    System.out.println(new ReverseInteger().reverse(-120));

  }
}