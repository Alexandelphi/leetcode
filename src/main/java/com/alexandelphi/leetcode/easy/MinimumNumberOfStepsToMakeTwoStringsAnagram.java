package com.alexandelphi.leetcode.easy;

import java.util.Arrays;

public class MinimumNumberOfStepsToMakeTwoStringsAnagram {

  // Runtime: 10 ms, faster than 74.89% of Java online submissions for Minimum Number of Steps to Make Two Strings Anagram.
  // Memory Usage: 41.9 MB, less than 100.00% of Java online submissions for Minimum Number of Steps to Make Two Strings Anagram.
  public int minSteps(String s, String t) {
    int[] count = new int[26];
    for (int c : s.toCharArray()) {
      count[c - 'a']++;
    }
    for (int c : t.toCharArray()) {
      if (count[c - 'a'] > 0) {
        count[c - 'a']--;
      }
    }
    return Arrays.stream(count).sum(); // we can see that lambda approach is slightly slower than general loop
  }

  // Runtime: 9 ms, faster than 93.14% of Java online submissions for Minimum Number of Steps to Make Two Strings Anagram.
  // Memory Usage: 42.2 MB, less than 100.00% of Java online submissions for Minimum Number of Steps to Make Two Strings Anagram.
  public int minStepsV2(String s, String t) {
    int[] count = new int[26];
    for (int c : s.toCharArray()) {
      count[c - 'a']++;
    }
    for (int c : t.toCharArray()) {
      if (count[c - 'a'] > 0) {
        count[c - 'a']--;
      }
    }
    int sum = 0;
    for (int i : count) {
      sum += i;
    }
    return sum;
  }
}
