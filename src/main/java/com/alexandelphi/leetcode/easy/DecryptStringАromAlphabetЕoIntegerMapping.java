package com.alexandelphi.leetcode.easy;

public class DecryptStringАromAlphabetЕoIntegerMapping {

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Decrypt String from Alphabet to Integer Mapping.
  // Memory Usage: 37.3 MB, less than 100.00% of Java online submissions for Decrypt String from Alphabet to Integer Mapping.
  // logic + string builder
  public String freqAlphabets(String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (i < s.length() - 2 && s.charAt(i + 2) == '#') {
        int firstDigit = s.charAt(i) - '0';
        int secondDigit = s.charAt(i + 1) - '0';
        sb.append((char) (firstDigit * 10 + secondDigit + 'a' - 1));
        i += 2;
      } else {
        sb.append((char) (s.charAt(i) - '1' + 'a'));
      }
    }
    return sb.toString();
  }
}
