package com.alexandelphi.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

  // my first naive solution with using DFS (old one solution)
  public List<List<Integer>> levelOrderDFS(TreeNode root) {
    List<List<Integer>> superList = new ArrayList<>();
    dfs(root, superList, 0);
    return superList;
  }

  private void dfs(TreeNode node, List<List<Integer>> levelLists, int i) {
    if (node != null) {
      if (levelLists.size() <= i) {
        levelLists.add(new ArrayList<Integer>());
      }
      levelLists.get(i).add(node.val);
      i++;
      dfs(node.left, levelLists, i);
      dfs(node.right, levelLists, i);
    }
  }


  // my second solution with BFS (after solving 70+ tasks on LeetCode)
  public List<List<Integer>> levelOrderBFS(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<List<Integer>> result = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      int size = q.size();
      List<Integer> list = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode node = q.poll();
        list.add(node.val);
        if (node.left != null) {
          q.add(node.left);
        }
        if (node.right != null) {
          q.add(node.right);
        }
      }
      result.add(list);
    }
    return result;
  }
}
