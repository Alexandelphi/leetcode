package com.alexandelphi.leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


public class BinaryTreePostorderTraversal {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public List<Integer> postorderTraversal(TreeNode root) {
    LinkedList<Integer> resultList = new LinkedList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode node = root;
    while (node != null || !stack.isEmpty()) {
      if (node != null) {
        stack.push(node);
        resultList.addFirst(node.val);
        node = node.right;
      } else {
        TreeNode temp = stack.pop();
        node = temp.left;
      }
    }
    return resultList;
  }
}