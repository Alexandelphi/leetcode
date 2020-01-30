package com.alexandelphi.leetcode.medium;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Runtime: 1 ms, faster than 23.63% of Java online submissions for Find Leaves of Binary Tree.
// Memory Usage: 39.1 MB, less than 6.82% of Java online submissions for Find Leaves of Binary Tree.
// my pretty straightforward as for me dfs solution
public class FindLeavesOfBinaryTree {
  public List<List<Integer>> findLeaves(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<List<Integer>> result = new ArrayList<>();
    TreeNode node = root;
    while (node.left != null || node.right != null) {
      List<Integer> list = new ArrayList<>();
      dfs(root, null, false, list);
      result.add(list);
    }
    result.add(Collections.singletonList(root.val));
    return result;
  }

  private void dfs(TreeNode curr, TreeNode prev, boolean isLeft, List<Integer> list) {
    if (curr == null) {
      return;
    }
    if (curr.left == null && curr.right == null) {
      list.add(curr.val);
      if (isLeft) {
        prev.left = null;
      } else {
        prev.right = null;
      }
    }
    dfs(curr.left, curr, true, list);
    dfs(curr.right, curr, false, list);
  }
}
