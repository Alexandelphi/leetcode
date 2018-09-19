package com.alexandelphi.leetcode.easy;

import java.util.Arrays;

class MoveZeroes {
  public void moveZeroes(int[] nums) {
    int numberOfZeroes = 0;

    for (int i = 0, j = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        nums[j] = nums[i];
        j++;
      } else {
        numberOfZeroes++;
      }
    }

    for (int i = nums.length - 1; numberOfZeroes > 0; i--) {
      nums[i] = 0;
      numberOfZeroes--;
    }
  }

  public static void main(String[] args) {
    int[] arr = new int[]{0,1,0,3,12};

    new MoveZeroes().moveZeroes(arr);
    System.out.println(Arrays.toString(arr));
  }
}