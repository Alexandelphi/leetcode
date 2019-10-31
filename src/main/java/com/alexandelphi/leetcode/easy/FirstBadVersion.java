package com.alexandelphi.leetcode.easy;


// Runtime: 10 ms, faster than 99.75% of Java online submissions for First Bad Version.
// Memory Usage: 33 MB, less than 100.00% of Java online submissions for First Bad Version.

public class FirstBadVersion {
  public int firstBadVersion(int n) {
    int low = 1;
    int high = n;
    while (low < high) {
      int mid = low + (high - low) / 2;
      if (!isBadVersion(mid)) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }
    return low;
  }

  private boolean isBadVersion(int i) {
    // The isBadVersion API is defined in the parent class VersionControl.
    // Mock method
    return false;
  }
}
