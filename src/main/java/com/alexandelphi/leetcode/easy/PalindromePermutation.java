package com.alexandelphi.leetcode.easy;

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
}
