package com.alexandelphi.leetcode.easy;

public class BestTimeToBuyAndSellStock {

  // Runtime: 1 ms, faster than 99.12% of Java online submissions for Best Time to Buy and Sell Stock.
  // Memory Usage: 39.8 MB, less than 10.62% of Java online submissions for Best Time to Buy and Sell Stock.
  public int maxProfit(int[] prices) {
    int minProfit = Integer.MAX_VALUE;
    int maxProfit = 0;
    for (int i = 0; i < prices.length - 1; i++) {
      minProfit = Math.min(minProfit, prices[i]);
      maxProfit = Math.max(maxProfit, prices[i + 1] - minProfit);
    }
    return maxProfit;
  }
}
