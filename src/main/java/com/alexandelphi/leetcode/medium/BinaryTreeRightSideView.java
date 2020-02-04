package com.alexandelphi.leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

  // dfs version, not finished yet
  // it will be updated soon
  public List<Integer> rightSideView(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<Integer> result = new ArrayList<>();
    dfs(root, result, 1);
    return result;
  }

  private int dfs(TreeNode node, List<Integer> list, int depth) {
    if (node == null) {
      return depth;
    }
    list.add(node.val);
    int left = 0, right = 0;
    if (node.right != null) {
      left = dfs(node.right, list, depth + 1);
    } else if (node.left != null) {
      right = dfs(node.left, list, depth + 1);
    }
    return Math.max(depth, Math.max(left, right));
  }


  // Runtime: 1 ms, faster than 87.21% of Java online submissions for Binary Tree Right Side View.
  // Memory Usage: 38.3 MB, less than 5.88% of Java online submissions for Binary Tree Right Side View.
  // simple bfs solution with adding the last element of the queue to the result list
  public List<Integer> rightSideViewV2(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<Integer> result = new ArrayList<>();
    Queue<TreeNode> q = new ArrayDeque<>();
    q.add(root);
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = q.poll();
        if (i == size - 1) {
          result.add(node.val);
        }
        if (node.left != null) q.add(node.left);
        if (node.right != null) q.add(node.right);
      }

    }
    return result;
  }
}
