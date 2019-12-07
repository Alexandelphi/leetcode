package com.alexandelphi.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Leaf-Similar Trees.
  // Memory Usage: 35 MB, less than 100.00% of Java online submissions for Leaf-Similar Trees.
  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    dfs(root1, list1);
    dfs(root2, list2);

    // as it's collection we can use "list1.equals(list2)"
    // but I decided to use for loop :-)
    for (int i = 0; i < list1.size() && list1.size() == list2.size(); i++) {
      if (!list1.get(i).equals(list2.get(i))) {
        return false;
      }
    }
    return true;
  }

  private void dfs(TreeNode node, List<Integer> list) {
    if (node == null) {
      return;
    }
    dfs(node.left, list);
    if (node.left == null && node.right == null) {
      list.add(node.val);
    }
    dfs(node.right, list);
  }
}
