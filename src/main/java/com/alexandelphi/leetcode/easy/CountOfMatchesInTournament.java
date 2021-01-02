package com.alexandelphi.leetcode.easy;

public class CountOfMatchesInTournament {
  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Count of Matches in Tournament.
  // Memory Usage: 35.8 MB, less than 59.77% of Java online submissions for Count of Matches in Tournament.
  public int numberOfMatches(int n) {
    int matches = 0;
    while (n >= 2) {
      if (n % 2 == 0) {
        matches += n / 2;
        n = n / 2;
      } else {
        matches += (n - 1) / 2;
        n = ((n - 1) / 2) + 1;
      }
    }
    return matches;
  }
}
