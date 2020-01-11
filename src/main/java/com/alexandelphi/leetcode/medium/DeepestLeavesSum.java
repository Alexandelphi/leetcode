package com.alexandelphi.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class DeepestLeavesSum {

  private int maxDepth = 0;

  // Runtime: 1 ms, faster than 99.88% of Java online submissions for Deepest Leaves Sum.
  // Memory Usage: 39.3 MB, less than 100.00% of Java online submissions for Deepest Leaves Sum
  // DFS solution
  public int deepestLeavesSum(TreeNode root) {
    int[] sum = new int[1];
    dfs(root, 1, sum);
    return sum[0];
  }

  private void dfs(TreeNode node, Integer depth, int[] sum) {
    if (node == null) {
      return;
    }
    if (depth > maxDepth) {
      maxDepth = depth;
      sum[0] = 0;
    }
    if (depth == maxDepth) {
      sum[0] += node.val;
    }
    dfs(node.left, depth + 1, sum);
    dfs(node.right, depth + 1, sum);
  }

  // Runtime: 4 ms, faster than 48.13% of Java online submissions for Deepest Leaves Sum.
  // Memory Usage: 39.2 MB, less than 100.00% of Java online submissions for Deepest Leaves Sum.
  // BFS solution
  public int deepestLeavesSumV2(TreeNode root) {
    int sum = 0;
    Deque<TreeNode> q = new ArrayDeque<>();
    q.add(root);
    while (!q.isEmpty()) {
      int size = q.size();
      sum = 0;
      for (int i = 0; i < size; i++) {
        TreeNode node = q.poll();
        sum += node.val;
        if (node.left != null) q.add(node.left);
        if (node.right != null) q.add(node.right);
      }
    }
    return sum;
  }


}
