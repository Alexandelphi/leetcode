package com.alexandelphi.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}

class BinaryTreeInOrderTraversal {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    recursiveInOrderTraversal(root, result);
    return result;
  }

  private void recursiveInOrderTraversal(TreeNode node, List<Integer> list) {
    if (node != null) {
      if (node.left != null) {
        recursiveInOrderTraversal(node.left, list);
      }
      list.add(node.val);
      if (node.right != null) {
        recursiveInOrderTraversal(node.right, list);
      }
    }
  }
}