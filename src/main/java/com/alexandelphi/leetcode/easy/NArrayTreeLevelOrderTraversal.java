package com.alexandelphi.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


// Definition for a Node.
class Node {
  public int val;
  public List<Node> children;

  public Node() {
  }

  public Node(int _val, List<Node> _children) {
    val = _val;
    children = _children;
  }
};

class NArrayTreeLevelOrderTraversal {
  public List<List<Integer>> levelOrder(Node root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<List<Integer>> result = new ArrayList<>();

    Queue<Node> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      List<Integer> list = new ArrayList<>();
      int size = q.size();
      for (int i = 0; i < size; i++) {
        Node current = q.poll();
        list.add(current.val);
        for (Node node : current.children) {
          q.add(node);
        }
      }
      result.add(list);
    }
    return result;
  }
}