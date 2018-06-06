package com.alexandelphi.leetcode;

public class PalindromeNumber {

  public boolean isPalindrome(int x) {
    if(x >= 0 && reverse(x) == x) {
      return true;
    }
    return false;
  }

  private int reverse(int num) {
    long result = 0;
    while (num != 0) {
      result = result * 10 + num % 10;
      num /= 10;
    }
    if (Integer.MIN_VALUE <= result && Integer.MAX_VALUE >= result) {
      return (int) result;
    } else {
      return 0;
    }
  }

  public static void main(String[] args) {
//    System.out.println(new PalindromeNumber().reverse(1147483648));
    System.out.println(new PalindromeNumber().isPalindrome(0));
  }
}
