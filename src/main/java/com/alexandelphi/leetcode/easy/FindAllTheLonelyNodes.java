package com.alexandelphi.leetcode.easy;


import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Find All The Lonely Nodes.
// Memory Usage: 39.6 MB, less than 65.35% of Java online submissions for Find All The Lonely Nodes.
public class FindAllTheLonelyNodes {
  public List<Integer> getLonelyNodes(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    dfs(root, true, result);
    return result;
  }

  private void dfs(TreeNode node, boolean hasFutureSiblings, List<Integer> result) {
    if (node == null) return;
    if (hasFutureSiblings == false) {
      result.add(node.val);
    }
    if (node.left != null && node.right != null) {
      hasFutureSiblings = true;
    } else {
      hasFutureSiblings = false;
    }
    dfs(node.left, hasFutureSiblings, result);
    dfs(node.right, hasFutureSiblings, result);
  }
}