package com.alexandelphi.leetcode.easy;

// Runtime: 1 ms, faster than 100.00% of Java online submissions for Construct String from Binary Tree.
// Memory Usage: 38.1 MB, less than 94.74% of Java online submissions for Construct String from Binary Tree.

public class ConstructStringFromBinaryTree {

  public String tree2str(TreeNode t) {
    StringBuilder sb = new StringBuilder();
    dfs(t, sb);
    return sb.toString();
  }

  private void dfs(TreeNode node, StringBuilder sb) {
    if (node == null) {
      return;
    }
    sb.append(node.val);
    if (node.left != null) {
      sb.append("(");
      dfs(node.left, sb);
      sb.append(")");
    }
    if (node.right != null) {
      if (node.left == null) { // here is the moment which can be a little unclear
        sb.append("()");       //
      }
      sb.append("(");
      dfs(node.right, sb);
      sb.append(")");
    }
  }
}
