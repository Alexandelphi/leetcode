package com.alexandelphi.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
  // my naive solution
  public int longestPalindrome(String s) {
    if (s.length() == 0) {
      return 0;
    }
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    if (map.size() == 1) {
      return map.get(s.charAt(0));
    }
    int sum = 0;
    boolean foundOne = false;
    for (char c : map.keySet()) {
      int n = map.get(c);
      if (n / 2 == 0 || n % 2 > 0) {
        foundOne = true;
      }
      sum += n / 2;
    }
    return foundOne ? (sum * 2 + 1) : (sum * 2);
  }


  // my improved version
  // Runtime: 1 ms, faster than 100.00% of Java online submissions for Longest Palindrome.
  // Memory Usage: 35.8 MB, less than 100.00% of Java online submissions for Longest Palindrome.
  public int longestPalindromeV2(String s) {
    if (s.length() == 0) {
      return 0;
    }
    int[] count = new int[128];
    for (char c : s.toCharArray()) {
      count[c]++;
    }
    int sum = 0;
    boolean foundOne = false;
    for (int n : count) {
      if (n % 2 == 1) {
        foundOne = true;
      }
      sum += n / 2;
    }
    return foundOne ? (sum * 2 + 1) : (sum * 2);
  }
}
