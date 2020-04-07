package com.alexandelphi.leetcode.unknown;

public class CountingElements {

  // Runtime: 0 ms
  // Memory Usage: 37.4 MB
  // Sorry. We do not have enough accepted submissions to show distribution chart.
  // Day 7  -  30-Day LeetCoding Challenge
  // we have a constraint that a num can be from 1 to 1000, so we can use an array as hashmap
  public int countElements(int[] arr) {
    int resultCount = 0;
    int[] numCountMap = new int[1002];
    for (int num : arr) {
      numCountMap[num]++;
    }
    for (int num : arr) {
      if (numCountMap[num] > 0 && numCountMap[num + 1] > 0) {
        resultCount++;
      }
    }
    return resultCount;
  }
}
