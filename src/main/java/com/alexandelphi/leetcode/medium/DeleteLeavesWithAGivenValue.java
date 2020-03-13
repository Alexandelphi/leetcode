package com.alexandelphi.leetcode.medium;

public class DeleteLeavesWithAGivenValue {
  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Delete Leaves With a Given Value.
  // Memory Usage: 41.5 MB, less than 100.00% of Java online submissions for Delete Leaves With a Given Value.
  // recursive DFS solution
  public TreeNode removeLeafNodes(TreeNode root, int target) {
    if (root == null) {
      return root;
    }
    root.left = removeLeafNodes(root.left, target);
    root.right = removeLeafNodes(root.right, target);
    if (root.val == target && root.left == null && root.right == null) {
      return null;
    }
    return root;
  }
}
