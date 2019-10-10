package com.alexandelphi.leetcode.easy;

public class SumOfLeftLeaves {
  // my straightforward recursive solution, I know it can be better ...
  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return helper(root, 0);
  }

  private int helper(TreeNode node, int sum) {
    if (node.left != null) {
      if (node.left.left == null && node.left.right == null) {
        sum += node.left.val;
      }
      sum += helper(node.left, 0);
    }
    if (node.right != null) {
      sum += helper(node.right, 0);
    }
    return sum;
  }
}
