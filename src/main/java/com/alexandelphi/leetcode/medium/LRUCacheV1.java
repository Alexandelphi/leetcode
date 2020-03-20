package com.alexandelphi.leetcode.medium;


// Runtime: 151 ms, faster than 8.90% of Java online submissions for LRU Cache.
// Memory Usage: 50.6 MB, less than 96.93% of Java online submissions for LRU Cache.
// straightforward approach of usage custom LinkedList without HashMap

public class LRUCacheV1 {
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

  public LRUCacheV1(int capacity) {
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
    Node node = dummyHead.next;
    while (node != dummyTail) {
      if (node.key == key) {
        return node;
      }
      node = node.next;
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
    size++;
  }

  private Node remove(Node node) {
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
 * Your LRUCache object will be instantiated and called as such: LRUCache obj = new
 * LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */