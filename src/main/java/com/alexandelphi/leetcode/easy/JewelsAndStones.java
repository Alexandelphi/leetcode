package com.alexandelphi.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
  public int numJewelsInStones(String J, String S) {
    Set<Character> map = new HashSet<>();
    int result = 0;

    for (char c : J.toCharArray()) {
      map.add(c);
    }

    for (char c : S.toCharArray()) {
      if (map.contains(c)) {
        result++;
      }
    }
    return result;
  }
}