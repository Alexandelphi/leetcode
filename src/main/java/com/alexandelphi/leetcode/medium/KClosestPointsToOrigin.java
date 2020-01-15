package com.alexandelphi.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

  // Runtime: 34 ms, faster than 21.34% of Java online submissions for K Closest Points to Origin.
  // Memory Usage: 63.4 MB, less than 24.85% of Java online submissions for K Closest Points to Origin.
  // my solution based on priority queue
  public int[][] kClosest(int[][] points, int k) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> getOrigin(b) - getOrigin(a));
    for (int[] pair : points) {
      pq.add(pair);
      if (pq.size() > k) {
        pq.remove();
      }
    }
    int[][] result = new int[k][2];
    for (int i = k - 1; i >= 0; i--) {
      result[i] = pq.remove();
    }
    return result;
  }

  private int getOrigin(int[] arr) {
    // Note: at the begging I used "(int) Math.sqrt(...)" here and it was wrong,
    // as I removed float part of result by converting double -> int, but then I realized that
    // we could just simplify the equation and use a^2 + b^2, where 'a' is arr[0] and 'b' is arr[1]
    return arr[0] * arr[0] + arr[1] * arr[1];
  }


  // Runtime: 34 ms, faster than 21.34% of Java online submissions for K Closest Points to Origin.
  // Memory Usage: 60.4 MB, less than 60.87% of Java online submissions for K Closest Points to Origin.
  public int[][] kClosestV2(int[][] points, int k) {
    Arrays.sort(points, Comparator.comparing(arr -> arr[0] * arr[0] + arr[1] * arr[1]));
    return Arrays.copyOfRange(points, 0, k);
  }
}
