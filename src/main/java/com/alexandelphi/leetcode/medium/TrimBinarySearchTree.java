package com.alexandelphi.leetcode.medium;

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Trim a Binary Search Tree.
// Memory Usage: 38.5 MB, less than 86.07% of Java online submissions for Trim a Binary Search Tree.
public class TrimBinarySearchTree {
  public TreeNode trimBST(TreeNode root, int low, int high) {
    if (root == null) return root;
    TreeNode left = null;
    TreeNode right = null;
    if (root.val >= low && root.val <= high) {
      left = trimBST(root.left, low, high);
      right = trimBST(root.right, low, high);
    } else if (root.val < low) {
      return trimBST(root.right, low, high);
    } else if (root.val > high) {
      return trimBST(root.left, low, high);
    }
    root.left = left;
    root.right = right;
    return root;
  }
}