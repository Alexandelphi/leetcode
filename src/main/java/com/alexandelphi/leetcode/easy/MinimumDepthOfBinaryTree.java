package com.alexandelphi.leetcode.easy;

public class MinimumDepthOfBinaryTree {

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Depth of Binary Tree.
  // Memory Usage: 44.5 MB, less than 6.25% of Java online submissions for Minimum Depth of Binary Tree.
  // recursive version with DFS
  public int minDepth(TreeNode root) {
    int depth = helper(root, 1);
    return depth == Integer.MAX_VALUE ? 0 : depth;
  }

  private int helper(TreeNode node, int depth) {
    if (node == null) {
      return Integer.MAX_VALUE;
    }
    if (node.left == null && node.right == null) {
      return depth;
    }
    return Math.min(helper(node.left, depth + 1), helper(node.right, depth + 1));
  }

  // iterative version with BFS
  // it will be added :-)
  public int minDepthV2(TreeNode root) {
    return 0;
  }
}
