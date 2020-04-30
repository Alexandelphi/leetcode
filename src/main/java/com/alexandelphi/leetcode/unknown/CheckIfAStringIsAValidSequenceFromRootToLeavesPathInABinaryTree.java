package com.alexandelphi.leetcode.unknown;

public class CheckIfAStringIsAValidSequenceFromRootToLeavesPathInABinaryTree {

  // Runtime: 0 ms
  // Memory Usage: 40.6 MB
  // Accepted Solutions Runtime Distribution
  // Sorry. We do not have enough accepted submissions to show distribution chart.
  // Accepted Solutions Memory Distribution
  // Sorry. We do not have enough accepted submissions to show distribution chart.

  public boolean isValidSequence(TreeNode root, int[] arr) {
    return dfs(root, arr, 0);
  }

  private boolean dfs(TreeNode node, int[] arr, int index) {
    if (node == null && index < arr.length) {
      return false;
    }
    if (index < arr.length) {
      if (node.val != arr[index]) {
        return false;
      }
      if (index == arr.length - 1 && node.left == null && node.right == null) {
        return true;
      }
      return dfs(node.left, arr, index + 1) | dfs(node.right, arr, index + 1);
    }
    return false;
  }

  // Definition for a binary tree node.
  private class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
