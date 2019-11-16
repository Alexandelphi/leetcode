package com.alexandelphi.leetcode.easy;

public class RemoveAllAdjacentDuplicatesInString {

  //  Runtime: 11 ms, faster than 77.58% of Java online submissions for Remove All Adjacent Duplicates In String.
  //  Memory Usage: 38.1 MB, less than 100.00% of Java online submissions for Remove All Adjacent Duplicates In String.

  public String removeDuplicates(String S) {
    StringBuilder sb = new StringBuilder();
    char[] arr = S.toCharArray();
    for (int i = 0; i < arr.length; i++) {
      if (sb.length() != 0 && sb.charAt(sb.length() - 1) == arr[i]) {
        sb.deleteCharAt(sb.length() - 1);
      } else {
        sb.append(arr[i]);
      }
    }
    return sb.toString();
  }
}
