package com.alexandelphi.leetcode.easy;

public class ClosestBinarySearchTreeValue {
  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Closest Binary Search Tree Value.
  // Memory Usage: 38.1 MB, less than 97.44% of Java online submissions for Closest Binary Search Tree Value.
  // recursive approach
  public int closestValueV1(TreeNode root, double target) {
    return binarySearch(root, target, root.val);
  }

  private int binarySearch(TreeNode node, double target, int prev) {
    if (node == null) {
      return prev;
    }
    int result = binarySearch(target < node.val ? node.left : node.right, target, node.val);
    return Math.abs(result - target) < Math.abs(node.val - target) ? result : node.val;
  }

  //  Runtime: 0 ms, faster than 100.00% of Java online submissions for Closest Binary Search Tree Value.
  //  Memory Usage: 37.1 MB, less than 100.00% of Java online submissions for Closest Binary Search Tree Value.
  // iterative approach
  public int closestValueV2(TreeNode root, double target) {
    TreeNode node = root;
    int closest = node.val;
    while (node != null) {
      if (Math.abs(node.val - target) < Math.abs(closest - target)) {
        closest = node.val;
      }
      node = node.val < target ? node.right : node.left;
    }
    return closest;
  }
}
