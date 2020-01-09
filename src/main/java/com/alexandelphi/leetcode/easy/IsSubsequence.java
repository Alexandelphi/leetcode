package com.alexandelphi.leetcode.easy;

public class IsSubsequence {
  // Runtime: 474 ms, faster than 5.02% of Java online submissions for Is Subsequence.
  // Memory Usage: 318 MB, less than 8.00% of Java online submissions for Is Subsequence.
  // emm, it's not optimal for this problem, but it works fine :-)
  // my dp solution which can be used for "Longest Common Subsequence"
  // and I'll add more optimal solutions later on
  // time/space complexity is O(m * n)
  public boolean isSubsequence(String s, String t) {
    int m = t.length();
    int n = s.length();
    int[][] dp = new int[m + 1][n + 1];
    for (int row = 1; row <= m; row++) {
      for (int col = 1; col <= n; col++) {
        if (s.charAt(col - 1) == t.charAt(row - 1)) {
          dp[row][col] = dp[row - 1][col - 1] + 1;
        } else {
          dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]);
        }
      }
    }
    return dp[m][n] == s.length();
  }

  // Runtime: 17 ms, faster than 47.29% of Java online submissions for Is Subsequence.
  // Memory Usage: 48.2 MB, less than 100.00% of Java online submissions for Is Subsequence.
  // my second solution, just linear time, O(n)
  public boolean isSubsequenceV2(String s, String t) {
    if (s.length() == 0) {
      return true;
    }
    int targetIndex = 0;
    for (int i = 0; i < t.length(); i++) {
      if (t.charAt(i) == s.charAt(targetIndex)) {
        ++targetIndex;
        if (targetIndex == s.length()) {
          return true;
        }
      }
    }
    return false;
  }
}
