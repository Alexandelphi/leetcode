package com.alexandelphi.leetcode.medium;

public class WordSearch {
  // Runtime: 5 ms, faster than 91.27% of Java online submissions for Word Search.
  // Memory Usage: 41.5 MB, less than 76.81% of Java online submissions for Word Search.
  // backtracking solution
  public boolean exist(char[][] board, String word) {
    boolean[][] visited = new boolean[board.length][board[0].length];

    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[0].length; col++) {
        if (backtrack(board, word, 0, row, col, visited)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean backtrack(char[][] board, String word, int wordIndex,
                            int row, int col, boolean[][] visited) {
    if (word.length() == wordIndex) {
      return true;
    }
    if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col]) {
      return false;
    }
    if (board[row][col] != word.charAt(wordIndex)) {
      return false;
    }

    visited[row][col] = true;
    boolean left = backtrack(board, word, wordIndex + 1, row, col - 1, visited);
    boolean right = backtrack(board, word, wordIndex + 1, row, col + 1, visited);
    boolean up = backtrack(board, word, wordIndex + 1, row - 1, col, visited);
    boolean down = backtrack(board, word, wordIndex + 1, row + 1, col, visited);
    if (left || right || up || down) {
      return true;
    }
    visited[row][col] = false;
    return false;
  }
}
