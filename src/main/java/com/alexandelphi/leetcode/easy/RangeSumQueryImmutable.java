package com.alexandelphi.leetcode.easy;

public class RangeSumQueryImmutable {

  // Runtime: 6 ms, faster than 100.00% of Java online submissions for Range Sum Query - Immutable.
  // Memory Usage: 42.6 MB, less than 43.90% of Java online submissions for Range Sum Query - Immutable.
  // prefix sum algorithm

  private int[] sum;

  public RangeSumQueryImmutable(int[] nums) {
    sum = new int[nums.length + 1];
    for (int i = 0; i < nums.length; i++) {
      sum[i + 1] = sum[i] + nums[i];
    }
  }

  public int sumRange(int i, int j) {
    return sum[j + 1] - sum[i];
  }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */