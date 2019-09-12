package com.alexandelphi.leetcode.easy;

public class DiameterOfBinaryTree {
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
  private int max = 0;

  // optimized solution
  public int diameterOfBinaryTree(TreeNode root) {
    getDepth(root);
    return max;
  }

  private int getDepth(TreeNode node) {
    if (node == null) {
      return 0;
    }
    int left = getDepth(node.left);
    int right = getDepth(node.right);
    max = Math.max(max, left + right);
    return Math.max(left, right) + 1;
  }

  // another solution
  public int diameterOfBinaryTree2(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int currentDepth = getDepth2(root.right) + getDepth2(root.left);
    int leftDepth = diameterOfBinaryTree(root.left);
    int rightDepth = diameterOfBinaryTree(root.right);
    return Math.max(currentDepth, Math.max(leftDepth, rightDepth));
  }

  private int getDepth2(TreeNode node) {
    if (node == null) {
      return 0;
    }
    return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
  }
}