package com.alexandelphi.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class SumOfRootToLeafBinaryNumbers {

  //  Runtime: 2 ms, faster than 29.15% of Java online submissions for Sum of Root To Leaf Binary Numbers.
  //  Memory Usage: 36.8 MB, less than 100.00% of Java online submissions for Sum of Root To Leaf Binary Numbers.

  // my easy and straightforward solution, but the usage of ArrayList is redundant and it's not optimal
  // I'll update it soon

  public int sumRootToLeaf(TreeNode root) {
    List<String> list = new ArrayList<>();
    dfs(root, "", list);
    int sum = 0;
    for (String str : list) {
      sum += Integer.parseInt(str, 2);
    }
    return sum;
  }

  private void dfs(TreeNode node, String str, List<String> list) {
    if (node == null) {
      return;
    }
    str += node.val;
    if (node.left == null && node.right == null) {
      list.add(str);
    }
    if (node.left != null) {
      dfs(node.left, str, list);
    }
    if (node.right != null) {
      dfs(node.right, str, list);
    }
  }
}
