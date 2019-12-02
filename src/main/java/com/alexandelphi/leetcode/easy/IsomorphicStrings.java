package com.alexandelphi.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
  // Runtime: 31 ms, faster than 5.53% of Java online submissions for Isomorphic Strings.
  // Memory Usage: 37.2 MB, less than 100.00% of Java online submissions for Isomorphic Strings.
  // my 1st solution
  public boolean isIsomorphic1(String s, String t) {
    Map<Character, Integer> map1 = new HashMap<>();
    Map<Character, Integer> map2 = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      int index1 = -1;
      int index2 = -1;
      if (map1.containsKey(s.charAt(i))) {
        index1 = map1.get(s.charAt(i));
      }
      if (map2.containsKey(t.charAt(i))) {
        index2 = map2.get(t.charAt(i));
      }
      if (index1 != index2) {
        return false;
      }
      map1.put(s.charAt(i), i);
      map2.put(t.charAt(i), i);
    }
    return true;
  }

  // Runtime: 5 ms, faster than 79.30% of Java online submissions for Isomorphic Strings.
  // Memory Usage: 37.2 MB, less than 100.00% of Java online submissions for Isomorphic Strings.
  // my 2nd solution
  public boolean isIsomorphic2(String s, String t) {
    char[] map1 = new char[256];
    char[] map2 = new char[256];
    for (int i = 0; i < s.length(); i++) {
      if (map1[s.charAt(i)] == 0 && map2[t.charAt(i)] == 0) {
        map1[s.charAt(i)] = t.charAt(i);
        map2[t.charAt(i)] = s.charAt(i);
      } else {
        if (map1[s.charAt(i)] != t.charAt(i) || map2[t.charAt(i)] != s.charAt(i)) {
          return false;
        }
      }
    }
    return true;
  }
}
