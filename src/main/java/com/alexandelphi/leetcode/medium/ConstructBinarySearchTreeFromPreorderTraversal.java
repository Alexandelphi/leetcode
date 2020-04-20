package com.alexandelphi.leetcode.medium;


// Runtime: 0 ms, faster than 100.00% of Java online submissions for Construct Binary Search Tree from Preorder Traversal.
// Memory Usage: 37.6 MB, less than 100.00% of Java online submissions for Construct Binary Search Tree from Preorder Traversal.

public class ConstructBinarySearchTreeFromPreorderTraversal {
  /**
   * Definition for a binary tree node.
   * public class TreeNode {
   *     int val;
   *     TreeNode left;
   *     TreeNode right;
   *     TreeNode(int x) { val = x; }
   * }
   */

  public TreeNode bstFromPreorder(int[] preorder) {
    TreeNode root = new TreeNode(preorder[0]);
    for (int i = 1; i < preorder.length; i++) {
      addNode(root, preorder[i]);
    }
    return root;
  }

  private void addNode(TreeNode node, int value) {
    if (value < node.val) {
      if (node.left == null) {
        node.left = new TreeNode(value);
      } else {
        addNode(node.left, value);
      }
    } else {
      if (node.right == null) {
        node.right = new TreeNode(value);
      } else {
        addNode(node.right, value);
      }
    }
  }
}

