package com.alexandelphi.leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// My solution which is based on BFS, I couldn't solve it at first time when I saw this problem ...
// Now I managed to solve it quite easy, but before this solution I've solved 100+ problems ...
// Have been learning Algorithms and Data Structures
// So, I just needed more experience and practice. Just don't give up and keep going!
//
// Runtime: 1 ms, faster than 98.87% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
// Memory Usage: 36.3 MB, less than 99.04% of Java online submissions for Binary Tree Zigzag Level Order Traversal.

public class BinaryTreeZigzagLevelOrderTraversal {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<List<Integer>> result = new ArrayList<>();
    Deque<TreeNode> deque = new ArrayDeque<>();
    deque.add(root);
    boolean isReversed = false;
    while (!deque.isEmpty()) {
      int size = deque.size();
      LinkedList<Integer> list = new LinkedList<>();
      for (int i = 0; i < size; i++) {
        TreeNode node = deque.poll();
        if (!isReversed) {
          list.add(node.val);
        } else {
          list.addFirst(node.val);
        }
        if (node.left != null) {
          deque.add(node.left);
        }
        if (node.right != null) {
          deque.add(node.right);
        }
      }
      result.add(list);
      if (!isReversed) {
        isReversed = true;
      } else {
        isReversed = false;
      }
    }
    return result;
  }
}
