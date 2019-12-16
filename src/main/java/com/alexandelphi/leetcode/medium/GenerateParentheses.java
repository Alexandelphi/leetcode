package com.alexandelphi.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

  // Runtime: 1 ms, faster than 95.06% of Java online submissions for Generate Parentheses.
  // Memory Usage: 36 MB, less than 100.00% of Java online submissions for Generate Parentheses.
  // wow, my second backtracking task solved!!!
  // yeah, I know the task can be really easy for many ppl, but for me it was challenging...
  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    generate("", n, n, result);
    return result;
  }

  private void generate(String str, int open, int close, List<String> result) {
    if (open == 0 && close == 0) {
      result.add(str);
      return;
    }
    if (open > 0) {
      --open;
      generate(str + "(", open, close, result);
      ++open;
    }
    if (close > 0 && open < close) {
      --close;
      generate(str + ")", open, close, result);
      ++close;
    }
  }
}
