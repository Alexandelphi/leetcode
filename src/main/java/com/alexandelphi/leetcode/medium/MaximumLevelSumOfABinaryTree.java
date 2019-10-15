package com.alexandelphi.leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaximumLevelSumOfABinaryTree {


  // my straightforward solution
  private Map<Integer, Integer> cache = new HashMap<>();

  public int maxLevelSum(TreeNode root) {
    traverseDFS(root, 1);
    int maxDepthLevel = 1;
    for (int i : cache.keySet()) {
      if (cache.get(i) > cache.get(maxDepthLevel)) {
        maxDepthLevel = i;
      }
    }
    return maxDepthLevel;
  }

  private void traverseDFS(TreeNode node, int level) {
    if (node == null) {
      return;
    }
    cache.put(level, cache.getOrDefault(level, 0) + node.val);
    traverseDFS(node.left, level + 1);
    traverseDFS(node.right, level + 1);
  }


  //  my faster solution, 14.11.19
  //  Runtime: 3 ms, faster than 100.00% of Java online submissions for Maximum Level Sum of a Binary Tree.
  //  Memory Usage: 41.4 MB, less than 100.00% of Java online submissions for Maximum Level Sum of a Binary Tree.

  private int[] cacheV2 = new int[(int) Math.pow(10, 4) + 1];
  private int maxDepthLevel = 0;

  public int maxLevelSumV2(TreeNode root) {
    traverseDFSv2(root, 1);
    int maxLevelSum = 1;
    for (int i = 1; i <= maxDepthLevel; i++) {
      if (cacheV2[i] > cacheV2[maxLevelSum]) {
        maxLevelSum = i;
      }
    }
    return maxLevelSum;
  }

  private void traverseDFSv2(TreeNode node, int level) {
    if (node == null) {
      return;
    }
    cacheV2[level] += node.val;
    maxDepthLevel = Math.max(maxDepthLevel, level);
    traverseDFS(node.left, level + 1);
    traverseDFS(node.right, level + 1);
  }

  // my BFS solution
  //  Runtime: 9 ms, faster than 83.75% of Java online submissions for Maximum Level Sum of a Binary Tree.
  //  Memory Usage: 42.3 MB, less than 100.00% of Java online submissions for Maximum Level Sum of a Binary Tree.
  public int maxLevelSumV3(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int[] cache = new int[(int) Math.pow(10, 4) + 1];
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    int depthLevel = 0;
    while (!q.isEmpty()) {
      depthLevel++;
      int size = q.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = q.poll();
        cache[depthLevel] += node.val;
        if (node.left != null) {
          q.add(node.left);
        }
        if (node.right != null) {
          q.add(node.right);
        }
      }
    }
    int maxLevelSum = 0;
    for (int i = 0; i <= depthLevel; i++) {
      if (cache[i] > cache[maxLevelSum]) {
        maxLevelSum = i;
      }
    }
    return maxLevelSum;
  }
}
