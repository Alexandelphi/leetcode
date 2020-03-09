package com.alexandelphi.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class DecompressRunLengthEncodedList {
  // Runtime: 6 ms, faster than 25.44% of Java online submissions for Decompress Run-Length Encoded List.
  // Memory Usage: 41.7 MB, less than 100.00% of Java online submissions for Decompress Run-Length Encoded List.
  public int[] decompressRLElist(int[] nums) {
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < nums.length; i += 2) {
      for (int j = 0; j < nums[i]; j++) {
        result.add(nums[i + 1]);
      }
    }
    return result.stream().mapToInt(i -> i).toArray();
  }
}
