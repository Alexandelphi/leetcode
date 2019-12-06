package com.alexandelphi.leetcode.easy;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SecondMinimumNodeInABinaryTree {

  // Runtime: 1 ms, faster than 19.82% of Java online submissions for Second Minimum Node In a Binary Tree.
  // Memory Usage: 34 MB, less than 100.00% of Java online submissions for Second Minimum Node In a Binary Tree.
  // my a little strange, but interesting solution :-)
  public int findSecondMinimumValue(TreeNode root) {
    Set<Integer> set = new TreeSet<>();
    dfs(root, set);
    if (set.size() > 1) {
      int result = 0;
      Iterator value = set.iterator();
      int i = 0;
      while (value.hasNext() && i < 2) {
        result = (int) value.next();
        i++;
      }
      return result;
    } else {
      return -1;
    }
  }

  private void dfs(TreeNode node, Set<Integer> set) {
    if (node == null) {
      return;
    }
    set.add(node.val);
    dfs(node.left, set);
    dfs(node.right, set);
  }
}
