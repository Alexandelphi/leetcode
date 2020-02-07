package com.alexandelphi.leetcode.easy;

public class LowestCommonAncestorOfABinarySearchTree {

  // Runtime: 4 ms, faster than 99.45% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
  // Memory Usage: 42.3 MB, less than 5.10% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
  // dfs solution
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    return helper(root, p, q);
  }

  private TreeNode helper(TreeNode node, TreeNode p, TreeNode q) {
    if (node == null) return null;
    if (node == p || node == q) {
      return node;
    }
    TreeNode left = helper(node.left, p, q);
    TreeNode right = helper(node.right, p, q);
    if ((left == p && right == q) || (right == p && left == q)) {
      return node;
    }
    return left != null ? left : right;
  }
}
