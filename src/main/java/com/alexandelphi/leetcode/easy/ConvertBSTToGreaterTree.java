package com.alexandelphi.leetcode.easy;

public class ConvertBSTToGreaterTree {

  //Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert BST to Greater Tree.
  //Memory Usage: 42 MB, less than 37.50% of Java online submissions for Convert BST to Greater Tree.

  int sum = 0;

  public TreeNode convertBST(TreeNode root) {
    dfs(root);
    return root;
  }

  private void dfs(TreeNode node) {
    if (node == null) {
      return;
    }
    dfs(node.right);
    sum += node.val;
    node.val = sum;
    dfs(node.left);
  }
}
