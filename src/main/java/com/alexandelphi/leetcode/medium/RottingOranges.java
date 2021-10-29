package com.alexandelphi.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

// Runtime: 3 ms, faster than 68.52% of Java online submissions for Rotting Oranges.
// Memory Usage: 38.7 MB, less than 53.80% of Java online submissions for Rotting Oranges.


public class RottingOranges {
  private int countMinutes = -1;
  private int allOranges = 0;
  private int rottenOranges = 0;

  public int orangesRotting(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;

    Queue<int[]> queue = new LinkedList<>();
    boolean[][] visited = new boolean[rows][cols];
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (grid[row][col] == 1) {
          allOranges++;
        } else if (grid[row][col] == 2) {
          allOranges++;
          queue.add(new int[]{row, col}); // add rotten oranges
          visited[row][col] = true;
        }
      }
    }

    bfs(grid, visited, queue);

    if (allOranges == 0 && rottenOranges == 0) {
      return 0;
    }
    if (allOranges == rottenOranges) {
      return countMinutes;
    } else {
      return -1;
    }
  }

  private void incrementMinutes() {
    countMinutes++;
  }

  private void bfs(int[][] grid, boolean[][] visited, Queue<int[]> queue){
    int rows = grid.length;
    int cols = grid[0].length;

    int[] d = new int[]{0, -1, 0, 1, 0};

    int size = queue.size();
    while (!queue.isEmpty()) {
      if (size > 0) {
        incrementMinutes();
      }
      for (int i = 0; i < size; i++) {
        rottenOranges++;
        int[] pair = queue.poll();

        for (int j = 0; j < d.length - 1; j++) {
          int r = pair[0] + d[j];
          int c = pair[1] + d[j + 1];
          if (r < 0 || r >= rows || c < 0 || c >= cols
              || grid[r][c] == 0 || grid[r][c] == 2 || visited[r][c]) {
            continue;
          }

          visited[r][c] = true;
          queue.add(new int[]{r, c});
        }
      }

      size = queue.size();
    }
  }
}
