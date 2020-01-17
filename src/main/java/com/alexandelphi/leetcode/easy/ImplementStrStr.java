package com.alexandelphi.leetcode.easy;

public class ImplementStrStr {


  // Runtime: 3 ms, faster than 31.35% of Java online submissions for Implement strStr().
  // Memory Usage: 42.8 MB, less than 6.10% of Java online submissions for Implement strStr().

  public int strStr(String haystack, String needle) {
    if (needle.length() == 0) return 0;
    if (haystack.length() == 0) return -1;
    for (int i = 0; i < haystack.length(); i++) {
      for (int j = 0; j < needle.length(); j++) {
        if (haystack.length() - i < needle.length()) return -1;
        if (haystack.charAt(i + j) != needle.charAt(j)) break;
        if (j == needle.length() - 1) return i;
      }
    }
    return -1;
  }

  // Runtime: 3 ms, faster than 31.35% of Java online submissions for Implement strStr().
  // Memory Usage: 42.9 MB, less than 6.10% of Java online submissions for Implement strStr().
  // I thought it is an optimised version, but it is what it is ... :-)
  public int strStrV2(String haystack, String needle) {
    for (int i = 0; ; i++) {
      for (int j = 0; ; j++) {
        // j == needle.length() in order to prevent
        // IndexOutOfBoundEx at "haystack.charAt(i + j) != needle.charAt(j)"
        // when needle is empty
        if (j == needle.length()) return i;
        if (haystack.length() - i < needle.length()) return -1;
        if (haystack.charAt(i + j) != needle.charAt(j)) break;
      }
    }
  }
}
