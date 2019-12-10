package com.alexandelphi.leetcode.easy;

import java.util.HashMap;
import java.util.Map;


// Runtime: 118 ms, faster than 69.93% of Java online submissions for Two Sum III - Data structure design.
// Memory Usage: 52.8 MB, less than 5.00% of Java online submissions for Two Sum III - Data structure design.
// Just nothing to say .... I couldn't understand why my solution couldn't pass the last test case for a while ...
public class TwoSumIIIDataStructureDesign {

  private Map<Integer, Integer> map;

  /** Initialize your data structure here. */
  public TwoSumIIIDataStructureDesign() {
    map = new HashMap<>();
  }

  /** Add the number to an internal data structure.. */
  public void add(int number) {
    map.put(number, map.getOrDefault(number, 0) + 1);
  }

  /** Find if there exists any pair of numbers which sum is equal to the value. */
  public boolean find(int value) {
    for (int key : map.keySet()) {
      int searchValue = value - key;
      if (searchValue == key && map.get(searchValue) > 1) {
        return true;
      } else if (map.containsKey(searchValue) && searchValue != key) {
        return true;
      }
    }
    return false;
  }
}


/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
