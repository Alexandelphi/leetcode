package com.alexandelphi.leetcode.easy;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 Definition for a binary tree node.
 public class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;
   TreeNode(int x) { val = x; }
 }
*/

public class MinimumAbsoluteDifferenceInBST {
  Integer result = Integer.MAX_VALUE;
  Integer prevVal = null;

  public int getMinimumDifference(TreeNode root) {
    Deque<TreeNode> stack = new ArrayDeque<>();
    while (root != null || !stack.isEmpty()) {
      if (root != null) {
        stack.push(root);
        root = root.left;
      } else {
        TreeNode node = stack.pop();
        if (prevVal != null) {
          result = Math.min(result, node.val - prevVal);
        }
        prevVal = node.val;
        root = node.right;
      }
    }
    return result;
  }
}