package com.alexandelphi.leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class BackspaceStringCompare {

  // Runtime: 2 ms, faster than 49.98% of Java online submissions for Backspace String Compare.
  // Memory Usage: 34.4 MB, less than 100.00% of Java online submissions for Backspace String Compare.
  // my straightforward solution by using Stack
  public boolean backspaceCompare(String s, String t) {
    Deque<Character> stackS = new ArrayDeque<>();
    Deque<Character> stackT = new ArrayDeque<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '#' && !stackS.isEmpty()) {
        stackS.pop();
      } else if (ch != '#') {
        stackS.push(ch);
      }
    }
    for (int i = 0; i < t.length(); i++) {
      char ch = t.charAt(i);
      if (ch == '#' && !stackT.isEmpty()) {
        stackT.pop();
      } else if (ch != '#') {
        stackT.push(ch);
      }
    }
    if (stackS.size() != stackT.size()) {
      return false;
    } else {
      while (!stackS.isEmpty()) {
        char ch1 = stackS.pop();
        char ch2 = stackT.pop();
        if (ch1 != ch2) {
          return false;
        }
      }
    }
    return true;
  }
}
