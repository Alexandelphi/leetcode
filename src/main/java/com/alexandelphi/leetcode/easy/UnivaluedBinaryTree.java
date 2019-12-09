package com.alexandelphi.leetcode.easy;

public class UnivaluedBinaryTree {

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Univalued Binary Tree.
  // Memory Usage: 34.3 MB, less than 100.00% of Java online submissions for Univalued Binary Tree.
  // recursive solution
  public boolean isUnivalTreeV1(TreeNode root) {
    if (root == null) {
      return false;
    }
    return helper(root, root.val);
  }

  private boolean helper(TreeNode node, int value) {
    if (node == null) {
      return true;
    }
    return node.val == value && helper(node.left, value) && helper(node.right, value);
  }
}
