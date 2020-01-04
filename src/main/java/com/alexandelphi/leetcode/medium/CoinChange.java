package com.alexandelphi.leetcode.medium;

import java.util.Arrays;

public class CoinChange {

  // Runtime: 14 ms, faster than 48.83% of Java online submissions for Coin Change.
  // Memory Usage: 35.9 MB, less than 95.27% of Java online submissions for Coin Change.
  public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;
    for (int i = 1; i < dp.length; i++) {
      for (int coin : coins) {
        if (i - coin < 0) {
          continue;
        }
        dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
      }
    }
    return dp[amount] > amount ? -1 : dp[amount];
  }



  //  Runtime: 27 ms, faster than 16.35% of Java online submissions for Coin Change.
  //  Memory Usage: 35.7 MB, less than 98.82% of Java online submissions for Coin Change.
  public int coinChangeRecursion(int[] coins, int amount) {
    if (amount < 0) {
      return 0;
    }
    return coinHandler(coins, amount, new int[amount]);
  }

  private int coinHandler(int[] coins, int rem, int[] memo) {
    if (rem < 0) return -1;
    if (rem == 0) return 0;
    if (memo[rem - 1] != 0) return memo[rem - 1];
    int min = rem + 1;
    for (int coin : coins) {
      int result = coinHandler(coins, rem - coin, memo);
      if (result >= 0 && result < min) {
        min = result + 1;
      }
    }
    if (min == rem + 1) {
      memo[rem - 1] = -1;
    } else {
      memo[rem - 1] = min;
    }
    return memo[rem - 1];
  }


  public static void main(String[] args) {
    System.out.println(new CoinChange().coinChangeRecursion(new int[]{1,2,5}, 11));
  }
}
