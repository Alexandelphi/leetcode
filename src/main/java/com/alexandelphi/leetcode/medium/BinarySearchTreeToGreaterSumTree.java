package com.alexandelphi.leetcode.medium;

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Search Tree to Greater Sum Tree.
// Memory Usage: 36.9 MB, less than 100.00% of Java online submissions for Binary Search Tree to Greater Sum Tree.
// dfs solution with using once global variable
public class BinarySearchTreeToGreaterSumTree {
  private int globalValue = 0;

  public TreeNode bstToGst(TreeNode root) {
    dfs(root);
    return root;
  }

  private void dfs(TreeNode node) {
    if (node == null) {
      return;
    }
    dfs(node.right);
    node.val += globalValue;
    globalValue = node.val;
    dfs(node.left);
  }
}
