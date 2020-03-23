package com.alexandelphi.leetcode.easy;

public class AddStrings {
  // Runtime: 2 ms, faster than 97.84% of Java online submissions for Add Strings.
  // Memory Usage: 38.6 MB, less than 6.25% of Java online submissions for Add Strings.
  // A little math manipulation + string manipulation
  public String addStrings(String num1, String num2) {
    StringBuilder sb = new StringBuilder();
    int n1 = num1.length() - 1;
    int n2 = num2.length() - 1;
    int carry = 0;
    while (n1 >= 0 || n2 >= 0) {
      int d1 = 0;
      int d2 = 0;
      if (n1 >= 0) {
        d1 = num1.charAt(n1) - '0';
        n1--;
      }
      if (n2 >= 0) {
        d2 = num2.charAt(n2) - '0';
        n2--;
      }
      int res = d1 + d2 + carry;
      if (res > 9) {
        res = res % 10;
        carry = 1;
      } else {
        carry = 0;
      }
      sb.append((char) (res + '0'));
    }
    if (carry == 1) {
      sb.append("1");
    }
    return sb.reverse().toString();
  }
}
