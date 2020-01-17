package com.alexandelphi.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class PalindromePermutation {

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Palindrome Permutation.
  // Memory Usage: 41.1 MB, less than 5.88% of Java online submissions for Palindrome Permutation.
  // my solution which I like
  public boolean canPermutePalindrome(String s) {
    int[] count = new int[256];
    for (int i = 0; i < s.length(); i++) {
      count[s.charAt(i)]++;
    }
    int result = 0;
    for (int i = 0; i < count.length; i++) {
      result += (count[i] % 2);
    }
    return result < 2;
  }

  // Runtime: 1 ms, faster than 66.93% of Java online submissions for Palindrome Permutation.
  // Memory Usage: 41.1 MB, less than 5.88% of Java online submissions for Palindrome Permutation.
  // alternative version with HashSet
  public boolean canPermutePalindromeV2(String s) {
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      if (!set.add(s.charAt(i))) {
        set.remove(s.charAt(i));
      }
    }
    return set.size() < 2;
  }
}
