package com.alexandelphi.leetcode.easy;


// Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Vowels from a String.
// Memory Usage: 34.2 MB, less than 100.00% of Java online submissions for Remove Vowels from a String.

public class RemoveVowelsFromAString {

  private boolean[] vowelsMap;

  public RemoveVowelsFromAString() {
    vowelsMap = new boolean[26];
    vowelsMap['a' - 'a'] = true;
    vowelsMap['e' - 'a'] = true;
    vowelsMap['i' - 'a'] = true;
    vowelsMap['o' - 'a'] = true;
    vowelsMap['u' - 'a'] = true;
  }

  public String removeVowels(String S) {
    StringBuilder sb = new StringBuilder();
    for (char c : S.toCharArray()) {
      if (!vowelsMap[c - 'a']) {
        sb.append(c);
      }
    }
    return sb.toString();
  }
}
