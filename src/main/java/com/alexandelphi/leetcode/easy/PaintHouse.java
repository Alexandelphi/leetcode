package com.alexandelphi.leetcode.easy;

public class PaintHouse {

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Paint House.
  // Memory Usage: 40.6 MB, less than 70.59% of Java online submissions for Paint House.
  // we can use only 3 variables instead of dp array or storing in place, I think storing in place is not okay
  public int minCost(int[][] costs) {
    if (costs == null || costs.length == 0) {
      return 0;
    }
    int red = costs[0][0];
    int blue = costs[0][1];
    int green = costs[0][2];
    for (int i = 1; i < costs.length; i++) {
      int currRed = Math.min(blue, green) + costs[i][0];
      int currBlue = Math.min(red, green) + costs[i][1];
      int currGreen = Math.min(red, blue) + costs[i][2];
      red = currRed;
      blue = currBlue;
      green = currGreen;
    }
    return Math.min(Math.min(red, blue), green);
  }
}
