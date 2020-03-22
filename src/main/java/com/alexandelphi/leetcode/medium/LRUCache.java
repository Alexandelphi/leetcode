package com.alexandelphi.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

// Runtime: 17 ms, faster than 28.06% of Java online submissions for LRU Cache.
// Memory Usage: 53.2 MB, less than 83.44% of Java online submissions for LRU Cache.
// LRU with HashMap
class LRUCache {
  class Node {
    int key;
    int val;
    Node next;
    Node prev;
    public Node(int key, int val) {
      this.key = key;
      this.val = val;
    }
  }

  Node dummyHead = new Node(-1, -1);
  Node dummyTail = new Node(-1, -1);

  int initCap;
  int size;

  Map<Integer, Node> map = new HashMap<>();

  public LRUCache(int capacity) {
    dummyHead.next = dummyTail;
    initCap = capacity;
    size = 0;
  }

  public int get(int key) {
    Node node = findNode(key);
    if (node != dummyTail) {
      node = remove(node);
      addFirst(node.key, node.val);
    }
    // printAll();
    return node.val;
  }

  public void put(int key, int value) {
    findAndRemove(key);
    addFirst(key, value);
    // printAll();
  }

  private void printAll() {
    Node node = dummyHead.next;
    System.out.print("dummyHead->");
    while (node != dummyTail) {
      System.out.print(node.val + "->");
      node = node.next;
    }
    System.out.println("dummyTail");
  }

  private void findAndRemove(int key) {
    Node node = findNode(key);
    if (node != dummyTail) {
      remove(node);
    }
  }

  private Node findNode(int key) {
    if (map.containsKey(key)) {
      return map.get(key);
    }
    return dummyTail;
  }

  private void addFirst(int key, int value) {
    if (size > initCap - 1) {
      Node lastNode = dummyTail.prev;
      remove(lastNode);
    }
    Node head = dummyHead.next;
    Node newHead = new Node(key, value);
    dummyHead.next = newHead;
    newHead.next = head;
    newHead.prev = dummyHead;
    head.prev = newHead;
    map.put(key, newHead);
    size++;
  }

  private Node remove(Node node) {
    map.remove(node.key); // remove from map
    Node nextNode = node.next;
    Node prevNode = node.prev;
    node.next = null;
    node.prev = null;
    prevNode.next = nextNode;
    nextNode.prev = prevNode;
    size--;
    return node;
  }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

class Main {
  public static void main(String[] args) {
    LRUCache obj = new LRUCache(2);
    obj.put(1,1);
    obj.put(2,2);
    obj.get(1);
    obj.put(3, 3);
  }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj = new
 * LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */

