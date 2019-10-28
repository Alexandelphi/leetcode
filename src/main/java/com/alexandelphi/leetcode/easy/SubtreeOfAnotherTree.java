package com.alexandelphi.leetcode.easy;

// Runtime: 5 ms, faster than 96.73% of Java online submissions for Subtree of Another Tree.
// Memory Usage: 40.9 MB, less than 86.67% of Java online submissions for Subtree of Another Tree.

public class SubtreeOfAnotherTree {

  public boolean isSubtree(TreeNode s, TreeNode t) {
    if (s == null) return false;
    boolean result = helper(s, t);
    return result | isSubtree(s.left, t) | isSubtree(s.right, t);
  }

  private boolean helper(TreeNode s, TreeNode t) {
    if (s == null && t == null) return true;
    if (s == null || t == null) return false;
    return (s.val == t.val) && helper(s.left, t.left) && helper(s.right, t.right);
  }
}
