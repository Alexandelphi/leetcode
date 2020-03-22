package com.alexandelphi.leetcode.medium;

import java.util.LinkedHashMap;
import java.util.Map;

// Runtime: 11 ms, faster than 99.96% of Java online submissions for LRU Cache.
// Memory Usage: 53.9 MB, less than 80.98% of Java online submissions for LRU Cache.
// another version of LRU cache which is based on LinkedHashMap
public class LRUCacheV2 {

  LinkedHashMap<Integer, Integer> map;
  int lruSize;

  public LRUCacheV2(int capacity) {
    lruSize = capacity;
    map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
      protected boolean removeEldestEntry(Map.Entry<Integer, Integer> entry) {
        return size() > lruSize;
      }
    };
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      return map.get(key);
    }
    return -1;
  }

  public void put(int key, int value) {
    map.put(key, value);
  }
}
