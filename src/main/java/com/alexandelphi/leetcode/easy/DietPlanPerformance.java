package com.alexandelphi.leetcode.easy;

class DietPlanPerformance {
  public static int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
    int result = 0;
    int sum = 0;
    for (int i = 0; i < calories.length; i++) {
      sum += calories[i];
      if (i >= k - 1) {
        if (sum < lower) {
          result--;
        } else if (sum > upper) {
          result++;
        }
        sum -= calories[i - k + 1];
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] arr = {6,13,8,7,10,1,12,11};
    int k = 6;
    int lower = 5;
    int upper = 37;

    System.out.println(dietPlanPerformance(arr, k, lower, upper));
  }
}
