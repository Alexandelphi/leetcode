package com.alexandelphi.leetcode.medium;

public class InsertIntoABinarySearchTree {
  // Runtime: 3 ms, faster than 100.00% of Java online submissions for Insert into a Binary Search Tree.
  // Memory Usage: 38.4 MB, less than 100.00% of Java online submissions for Insert into a Binary Search Tree.
  // iterative solution based on easy traversing of binary search tree
  public TreeNode insertIntoBST(TreeNode root, int val) {
    TreeNode node = root;
    TreeNode prev = node;;
    while (node != null) {
      prev = node;
      if (node.val < val) {
        node = node.right;
      } else {
        node = node.left;
      }
    }
    if (prev.val < val) {
      prev.right = new TreeNode(val);
    } else {
      prev.left = new TreeNode(val);
    }
    return root;
  }
}
