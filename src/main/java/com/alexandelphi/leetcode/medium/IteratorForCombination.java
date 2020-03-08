package com.alexandelphi.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class IteratorForCombination {
}

// Runtime: 12 ms, faster than 61.76% of Java online submissions for Iterator for Combination.
//  Memory Usage: 43 MB, less than 100.00% of Java online submissions for Iterator for Combination.
class CombinationIterator {

  private Queue<String> queue;
  private String chars;

  public CombinationIterator(String characters, int combinationLength) {
    queue = new LinkedList<>(); // with ArrayDeque, Runtime: 11 ms, faster than 71.62% of Java online submissions for Iterator for Combination.
    chars = characters;
    backtrack(new StringBuilder(), combinationLength, 0);
  }

  private void backtrack(StringBuilder sb, int length, int index) {
    if (sb.length() == length) {
      queue.add(sb.toString());
      return;
    }
    for (int i = index; i < chars.length(); i++) {
      sb.append(chars.charAt(i));
      backtrack(sb, length, i + 1);
      sb.setLength(sb.length() - 1);
    }
  }

  public String next() {
    return queue.remove();
  }

  public boolean hasNext() {
    return !queue.isEmpty();
  }
}