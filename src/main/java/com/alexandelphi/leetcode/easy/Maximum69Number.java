package com.alexandelphi.leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class Maximum69Number {
  // Runtime: 1 ms, faster than 65.74% of Java online submissions for Maximum 69 Number.
  // Memory Usage: 36.2 MB, less than 100.00% of Java online submissions for Maximum 69 Number.
  // my solution with using stack :-)
  public int maximum69Number (int num) {
    Deque<Integer> stack = new ArrayDeque<>();
    while (num != 0) {
      stack.push(num % 10);
      num /= 10;
    }
    int result = 0;
    boolean isFound = false;
    while(!stack.isEmpty()) {
      result *= 10;
      if (!isFound && stack.peek() == 6) {
        isFound = true;
        stack.pop();
        result += 9;
      } else {
        result += stack.pop();
      }
    }
    return result;
  }
}
