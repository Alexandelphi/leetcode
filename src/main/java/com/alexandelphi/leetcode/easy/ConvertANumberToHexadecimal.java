package com.alexandelphi.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class ConvertANumberToHexadecimal {

  // Runtime: 1 ms, faster than 47.13% of Java online submissions for Convert a Number to Hexadecimal.
  // Memory Usage: 38.5 MB, less than 22.11% of Java online submissions for Convert a Number to Hexadecimal.

  private static final Map<Integer, Character> map = new HashMap<>();

  static {
    map.put(10, 'a');
    map.put(11, 'b');
    map.put(12, 'c');
    map.put(13, 'd');
    map.put(14, 'e');
    map.put(15, 'f');
  }

  public String toHex(int num) {
    if (num == 0) {
      return "0";
    }
    StringBuilder sb = new StringBuilder();
    long n = 0;
    if (num > 0) {
      n = (long) num;
    } else {
      n = 0xffffffffL + (long) num + 1l;
    }
    while (n != 0) {
      int digit = (int) (n % 16);
      if (0 >= digit || digit <= 9) {
        sb.append((char) (digit + '0'));
      } else {
        sb.append(map.get(digit));
      }
      n /= 16;
    }
    return sb.reverse().toString();
  }
}