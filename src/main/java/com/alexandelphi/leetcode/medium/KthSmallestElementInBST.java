package com.alexandelphi.leetcode.medium;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class KthSmallestElementInBST {

  // Runtime: 7 ms, faster than 6.15% of Java online submissions for Kth Smallest Element in a BST.
  // Memory Usage: 40.6 MB, less than 5.51% of Java online submissions for Kth Smallest Element in a BST.
  // my straightforward solution, I'll optimize it soon
  public int kthSmallest(TreeNode root, int k) {
    Set<Integer> set = new TreeSet<>();
    dfs(root, set);
    Iterator it = set.iterator();
    int i = 0;
    int result = 0;
    while (it.hasNext() && i < k) {
      result = (int) it.next();
      i++;
    }
    return result;
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
