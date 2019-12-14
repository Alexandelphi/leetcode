package com.alexandelphi.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {

  // Runtime: 98 ms, faster than 5.06% of Java online submissions for Meeting Rooms.
  // Memory Usage: 38.8 MB, less than 35.90% of Java online submissions for Meeting Rooms.
  public boolean canAttendMeetings(int[][] intervals) {
    for (int i = 0; i < intervals.length; i++) {
      int start1 = intervals[i][0];
      int end1 = intervals[i][1];
      for (int j = i + 1; j < intervals.length; j++) {
        int start2 = intervals[j][0];
        int end2 = intervals[j][1];
        if (Math.min(end1, end2) > Math.max(start1, start2)) {
          return false;
        }
      }
    }
    return true;
  }

  // Runtime: 6 ms, faster than 62.84% of Java online submissions for Meeting Rooms.
  // Memory Usage: 37.2 MB, less than 64.10% of Java online submissions for Meeting Rooms.
  public boolean canAttendMeetingsV2(int[][] intervals) {
    // Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    for (int i = 0; i < intervals.length - 1; i++) {
      int end1 = intervals[i][1];
      int start2 = intervals[i + 1][0];
      if (end1 > start2) {
        return false;
      }
    }
    return true;
  }
}
