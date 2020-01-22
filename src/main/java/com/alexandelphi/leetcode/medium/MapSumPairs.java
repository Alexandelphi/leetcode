package com.alexandelphi.leetcode.medium;

import java.util.HashMap;
import java.util.Map;


// Runtime: 33 ms, faster than 7.31% of Java online submissions for Map Sum Pairs.
// Memory Usage: 43.8 MB, less than 14.29% of Java online submissions for Map Sum Pairs.
// my trie solution

public class MapSumPairs {

  TrieNode root;

  class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isCompleted = false;
    int value;
  }

  /**
   * Initialize your data structure here.
   */
  public MapSumPairs() {
    root = new TrieNode();
  }

  public void insert(String key, int val) {
    TrieNode node = root;
    for (int i = 0; i < key.length(); i++) {
      TrieNode temp = node.children.get(key.charAt(i));
      if (temp != null) {
        node = temp;
      } else {
        TrieNode newNode = new TrieNode();
        node.children.put(key.charAt(i), newNode);
        node = newNode;
      }
    }
    node.isCompleted = true;
    node.value = val;
  }

  public int sum(String prefix) {
    TrieNode node = root;
    for (int i = 0; i < prefix.length(); i++) {
      TrieNode temp = node.children.get(prefix.charAt(i));
      if (temp != null) {
        node = temp;
      } else {
        return 0;
      }
    }
    return helper(node, 0);
  }

  private int helper(TrieNode node, int sum) {
    if (node == null) {
      return 0;
    }
    if (node.isCompleted) {
      sum += node.value;
    }
    for (char ch : node.children.keySet()) {
      TrieNode currNode = node.children.get(ch);
      sum += helper(currNode, 0);
    }
    return sum;
  }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */