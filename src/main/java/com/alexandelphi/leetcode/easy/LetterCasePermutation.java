package com.alexandelphi.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
  // Runtime: 7 ms, faster than 18.65% of Java online submissions for Letter Case Permutation.
  // Memory Usage: 54.4 MB, less than 8.00% of Java online submissions for Letter Case Permutation.
  // backtracking + string builder solution
  public List<String> letterCasePermutation(String str) {
    List<String> result = new ArrayList<>();
    backtrack(result, str, new StringBuilder(), 0);
    return result;
  }

  private void backtrack(List<String> result, String str, StringBuilder sb, int index) {
    if (sb.length() == str.length()) {
      result.add(sb.toString());
      return;
    }
    char ch = str.charAt(index);
    if (ch >= '0' && ch <= '9') {
      sb.append(Character.toLowerCase(ch));
      backtrack(result, str, sb, index + 1);
      sb.setLength(sb.length() - 1);
      return;
    }
    sb.append(Character.toLowerCase(ch));
    backtrack(result, str, sb, index + 1);
    sb.setLength(sb.length() - 1);

    sb.append(Character.toUpperCase(ch));
    backtrack(result, str, sb, index + 1);
    sb.setLength(sb.length() - 1);
  }
}
