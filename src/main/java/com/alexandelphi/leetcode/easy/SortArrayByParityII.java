package com.alexandelphi.leetcode.easy;

public class SortArrayByParityII {

  // first solution with extra space
  public int[] sortArrayByParityIIv1(int[] A) {
    int[] arr = new int[A.length];

    int indexEven = 0;
    int indexOdd = 1;
    for (int i = 0; i < A.length; i++) {
      if (A[i] % 2 == 0) {
        arr[indexEven] = A[i];
        indexEven += 2;
      } else {
        arr[indexOdd] = A[i];
        indexOdd += 2;
      }
    }
    return arr;
  }


  // in place solution
  public int[] sortArrayByParityIIv2(int[] A) {
    int indexEven = 0;
    int indexOdd = 1;

    while (indexEven < A.length) {
      while (indexEven < A.length && A[indexEven] % 2 == 0) {
        indexEven += 2;
      }
      while (indexOdd < A.length && A[indexOdd] % 2 == 1) {
        indexOdd += 2;
      }
      if (indexEven < A.length) {
        swap(A, indexEven, indexOdd);
      }
      indexEven += 2;
      indexOdd += 2;
    }
    return A;
  }

  private void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}
