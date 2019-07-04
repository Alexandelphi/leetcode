package com.alexandelphi.leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
https://leetcode.com/problems/valid-parentheses

This solution gives us:
Runtime: 1 ms, faster than 98.33% of Java online submissions for Valid Parentheses.
Memory Usage: 34 MB, less than 100.00% of Java online submissions for Valid Parentheses.
*/
public class ValidParentheses {
  public boolean isValid(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
        stack.push(s.charAt(i));
      } else {
        if (stack.peek() != null && (stack.peek() == '(' && s.charAt(i) == ')' ||
            stack.peek() == '{' && s.charAt(i) == '}' ||
            stack.peek() == '[' && s.charAt(i) == ']'
        )) {
          stack.pop();
        } else {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}
