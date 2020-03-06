package com.alexandelphi.leetcode.easy;

public class ReverseInteger {

  // my old and quite naive solution, the idea was pretty close to optimal one
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

  // Runtime: 1 ms, faster than 100.00% of Java online submissions for Reverse Integer.
  // Memory Usage: 36.7 MB, less than 5.55% of Java online submissions for Reverse Integer.
  // solution with long, but if long is not allowed that becomes a really tricky
  // and you have to check int overflow in advance
  public int reverseV2(int x) {
    long result = 0;
    while (x != 0) {
      result = result * 10 + x % 10;
      if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
        return 0;
      }
      x /= 10;
    }
    return (int) result;
  }

  public static void main(String[] args) {
    System.out.println(new ReverseInteger().reverse(-120));

  }
}