package com.alexandelphi.leetcode.easy;


// Runtime: 14 ms, faster than 74.15% of Java online submissions for Design HashMap.
// Memory Usage: 43.4 MB, less than 100.00% of Java online submissions for Design HashMap.
// chaining implementation
public class DesignHashMap {

  class Node {
    int key;
    int val;
    Node next;
    public Node(int key, int val) {
      this.key = key;
      this.val = val;
    }
  }

  int size;
  Node[] table;

  /** Initialize your data structure here. */
  public DesignHashMap() {
    size = 1000;
    table = new Node[size];
  }

  /** value will always be non-negative. */
  public void put(int key, int value) {
    int hash = (size - 1) & key;
    if (table[hash] == null) {
      table[hash] = new Node(key, value);
    } else {
      Node node = table[hash];
      Node last = null;
      while (node != null) {
        if (node.key == key) {
          node.val = value;
          return;
        }
        last = node;
        node = node.next;
      }
      last.next = new Node(key, value);
    }
  }

  /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
  public int get(int key) {
    int hash = (size - 1) & key;
    Node node = table[hash];
    while (node != null) {
      if (node.key == key) {
        return node.val;
      }
      node = node.next;
    }
    return -1;
  }

  /** Removes the mapping of the specified value key if this map contains a mapping for the key */
  public void remove(int key) {
    int hash = (size - 1) & key;
    if (table[hash] != null) {
      Node node = table[hash];
      Node prev = null;
      while (node != null) {
        if (node.key == key) {
          if (prev == null) {
            table[hash] = node.next;
            node.next = null;
          } else {
            prev.next = node.next;
          }
          return;
        }
        prev = node;
        node = node.next;
      }
    }
  }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */