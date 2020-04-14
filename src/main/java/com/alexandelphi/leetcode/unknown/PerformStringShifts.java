package com.alexandelphi.leetcode.unknown;

public class PerformStringShifts {

  // Runtime: 0 ms
  // Memory Usage: 37.6 MB
  // Accepted Solutions Runtime Distribution
  // Sorry. We do not have enough accepted submissions to show distribution chart.
  // Accepted Solutions Memory Distribution
  // Sorry. We do not have enough accepted submissions to show distribution chart.

  public String stringShift(String s, int[][] shift) {
    int resultShift = 0;
    for (int[] pair : shift) {
      if (pair[0] == 1) {
        resultShift += pair[1];
      } else {
        resultShift -= pair[1];
      }
    }
    char[] text = new char[s.length()];
    for (int i = 0; i < s.length(); i++) {
      text[i] = s.charAt((s.length() + i - (resultShift % s.length())) % s.length());
    }
    return new String(text);
  }
}
