package com.alexandelphi.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

  private class NodeList {
    public int val;
    public NodeList next;
    public NodeList random;

    public NodeList() {}

    public NodeList(int _val, NodeList _next, NodeList _random) {
      val = _val;
      next = _next;
      random = _random;
    }

    public NodeList(int val) {
      this.val = val;
    }
  }

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Copy List with Random Pointer.
  // Memory Usage: 41.6 MB, less than 5.61% of Java online submissions for Copy List with Random Pointer.
  // my solutions with using HashMap, but it can be solved with constant time.
  // Another solution will be added soon
  public NodeList copyRandomList(NodeList head) {
    if (head == null) {
      return head;
    }
    Map<NodeList, NodeList> map = new HashMap<>();
    NodeList node = head;
    while (node != null) {
      map.put(node, new NodeList(node.val));
      node = node.next;
    }
    node = head;
    while (node != null) {
      NodeList curr = map.get(node);
      curr.next = map.get(node.next);
      curr.random = map.get(node.random);
      node = node.next;
    }
    return map.get(head);
  }
}



