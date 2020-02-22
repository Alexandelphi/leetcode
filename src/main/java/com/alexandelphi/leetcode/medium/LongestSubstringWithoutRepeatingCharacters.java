package com.alexandelphi.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

  // Runtime: 6 ms, faster than 84.54% of Java online submissions for Longest Substring Without Repeating Characters.
  // Memory Usage: 41.2 MB, less than 5.20% of Java online submissions for Longest Substring Without Repeating Characters.
  // HashMap solution
  public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int maxLength = 0;
    int j = 0;
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (!map.containsKey(ch)) {
        map.put(ch, i);
      } else {
        j = Math.max(j, map.get(ch) + 1);
        map.put(ch, i);
      }
      maxLength = Math.max(maxLength, i - j + 1);
    }
    return maxLength;
  }
}
