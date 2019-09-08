package com.alexandelphi.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    int[] counter = new int[26];
    for (int i = 0; i < s.length(); i++) {
      counter[s.charAt(i) - 'a']++;
      counter[t.charAt(i) - 'a']--;
    }
    for (int count : counter) {
      if (count != 0) {
        return false;
      }
    }

    return true;
  }

  public boolean isAnagram2(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    Map<Character, Integer> map = new HashMap<>();
    char[] s1 = s.toCharArray();
    char[] t1 = t.toCharArray();
    for (char c : s1) {
      map.put(c, map.containsKey(c) ? (map.get(c) + 1) : 1);
    }
    for (char c : t1) {
      if (map.containsKey(c)) {
        int count = map.get(c);
        if (count > 1) {
          map.put(c, --count);
        } else {
          map.remove(c);
        }
      } else {
        return false;
      }
    }
    return true;
  }

  public boolean isAnagram3(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    char[] s1 = s.toCharArray();
    char[] t1 = t.toCharArray();
    Arrays.sort(s1);
    Arrays.sort(t1);
    return Arrays.equals(s1, t1);
  }
}