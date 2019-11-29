package com.alexandelphi.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

  private static Map<String, Integer> map;
  static {
    map = new HashMap<>();
    map.put("I", 1);
    map.put("V", 5);
    map.put("X", 10);
    map.put("L", 50);
    map.put("C", 100);
    map.put("D", 500);
    map.put("M", 1000);
    map.put("IV", 4);
    map.put("IX", 9);
    map.put("XL", 40);
    map.put("XC", 90);
    map.put("CD", 400);
    map.put("CM", 900);
  }

  public int romanToInt(String s) {
    int result = 0;
    for (int i = 0; i < s.length(); i++) {
      String search = "";
      if (i < s.length() - 1) {
        search = String.valueOf(s.charAt(i)) + String.valueOf(s.charAt(i + 1));
      }
      if (map.containsKey(search)) {
        result += map.get(search);
        i++;
      } else {
        result += map.get(String.valueOf(s.charAt(i)));
      }

    }
    return result;
  }
}
