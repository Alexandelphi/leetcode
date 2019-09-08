package com.alexandelphi.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode
 * { int val;
 * TreeNode left;
 * TreeNode
 * right; TreeNode(int x) { val = x; } }
 */

public class InvertBinaryTree {

  public TreeNode invertTreeIterative(TreeNode root) {
    if (root == null) {
      return null;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode current = queue.poll();
      TreeNode left = current.left;
      current.left = current.right;
      current.right = left;
      if (current.left != null) {
        queue.add(current.left);
      }
      if (current.right != null) {
        queue.add(current.right);
      }
    }
    return root;
  }

  public TreeNode invertTreeRecursive(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode left = invertTreeRecursive(root.left);
    TreeNode right = invertTreeRecursive(root.right);
    root.right = left;
    root.left = right;
    return root;
  }
}