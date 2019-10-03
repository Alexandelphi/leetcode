package com.alexandelphi.leetcode.easy;

public class FlippingAnImage {
  public int[][] flipAndInvertImage(int[][] A) {
    int[][] copy = A.clone();
    flipImage(copy);
    return copy;
  }

  private void flipImage(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      reverse(arr[i]);
      invertDigits(arr[i]);
    }
  }

  private void reverse(int[] arr) {
    int n = arr.length - 1;
    for (int i = 0; i <= n / 2; i++) {
      int tmp = arr[i];
      arr[i] = arr[n - i];
      arr[n - i] = tmp;
    }
  }

  private void invertDigits(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 0) {
        arr[i] = 1;
      } else {
        arr[i] = 0;
      }
    }
  }
}
