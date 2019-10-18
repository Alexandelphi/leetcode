package com.alexandelphi.leetcode.easy;



import java.util.ArrayList;
import java.util.List;


// Runtime: 1 ms, faster than 100.00% of Java online submissions for Binary Tree Paths.
// Memory Usage: 36.7 MB, less than 100.00% of Java online submissions for Binary Tree Paths.
//
// my straightforward solution with DFS
public class BinaryTreePaths {
  List<String> result = new ArrayList<>();

  public List<String> binaryTreePaths(TreeNode root) {
    dfs(root, "");
    return result;
  }

  private void dfs(TreeNode node, String str) {
    if (node == null) {
      return;
    }
    str += node.val;
    if (node.left != null) dfs(node.left, str + "->");
    if (node.right != null) dfs(node.right, str + "->");
    if (node.left == null && node.right == null) {
      result.add(str);
    }
  }
}
