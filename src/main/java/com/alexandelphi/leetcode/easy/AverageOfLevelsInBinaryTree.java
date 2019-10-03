package com.alexandelphi.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



//class TreeNode {
//  int val;
//  TreeNode left;
//  TreeNode right;
//
//  TreeNode(int x) {
//    val = x;
//  }
//}

public class AverageOfLevelsInBinaryTree {
  public List<Double> averageOfLevels(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<Double> result = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      int size = q.size();
      double sum = 0;
      for (int i = 0; i < size; i++) {
        TreeNode node = q.poll();
        sum += node.val;
        if (node.left != null) {
          q.add(node.left);
        }
        if (node.right != null) {
          q.add(node.right);
        }
      }
      result.add(sum / size);
    }
    return result;
  }
}
