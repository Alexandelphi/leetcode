package com.alexandelphi.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;


// Runtime: 38 ms, faster than 32.73% of Java online submissions for My Calendar I.
// Memory Usage: 52.9 MB, less than 5.26% of Java online submissions for My Calendar I.
// naive and not efficient approach
class MyCalendarI {

  private List<int[]> list;

  public MyCalendarI() {
    list = new ArrayList<>();
  }

  public boolean book(int start, int end) {
    for (int[] el : list) {
      if (end > el[0] && start < el[1]) {
        return false;
      }
    }
    return list.add(new int[] {start, end});
  }
}


// Runtime: 38 ms, faster than 32.73% of Java online submissions for My Calendar I.
// Memory Usage: 49.3 MB, less than 47.37% of Java online submissions for My Calendar I.
// optimised solution with O(n*log(n))
class MyCalendarIv2 {

  private TreeMap<Integer, Integer> calendar;

  public MyCalendarIv2() {
    calendar = new TreeMap<>();
  }

  public boolean book(int start, int end) {
    Integer before = calendar.floorKey(start);
    Integer after = calendar.ceilingKey(start);
    if ((before != null && calendar.get(before) > start)
        || (after != null && end > after)) {
      return false;
    }
    calendar.put(start, end);
    return true;
  }
}

// Runtime: 35 ms, faster than 60.30% of Java online submissions for My Calendar I.
//  Memory Usage: 49.1 MB, less than 47.37% of Java online submissions for My Calendar I.
// slightly faster version
class MyCalendarIv3 {

  private TreeMap<Integer, Integer> calendar;

  public MyCalendarIv3() {
    calendar = new TreeMap<>();
  }

  public boolean book(int start, int end) {
    Integer before = calendar.floorKey(start);
    if (before != null && calendar.get(before) > start) {
      return false;
    }
    Integer after = calendar.ceilingKey(start);
    if (after != null && end > after) {
      return false;
    }
    calendar.put(start, end);
    return true;
  }
}