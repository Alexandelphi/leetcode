package com.alexandelphi.leetcode.easy;

import java.util.ArrayDeque;
import java.util.Queue;


// Runtime: 14 ms, faster than 76.24% of Java online submissions for Design Compressed String Iterator.
// Memory Usage: 40.4 MB, less than 100.00% of Java online submissions for Design Compressed String Iterator.
// no regexp, just clean logic + queue
public class DesignCompressedStringIterator {
  private Queue<Character> charList = new ArrayDeque<>();
  private Queue<Integer> countList = new ArrayDeque<>();
  private char ch = ' ';
  private int globalCount = 0;

  public DesignCompressedStringIterator(String compressedString) {
    String str = compressedString;
    for (int i = 0; i < str.length() - 1; i++) {
      char ch = str.charAt(i);
      int count = 0;
      while (i < str.length() - 1 && checkIfDigit(str.charAt(i + 1))) {
        count *= 10;
        count += str.charAt(i + 1) - '0';
        i++;
      }
      charList.add(ch);
      countList.add(count);
    }
  }

  private boolean checkIfDigit(char ch) {
    return ch >= '0' && ch <= '9';
  }

  public char next() {
    if (globalCount == 0 && hasNext()) {
      ch = charList.poll();
      globalCount = countList.poll();
    }
    if (!hasNext()) {
      return ' ';
    }
    globalCount--;
    return ch;
  }

  public boolean hasNext() {
    return !charList.isEmpty() || globalCount != 0;
  }
}
