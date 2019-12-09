package com.alexandelphi.leetcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoSumIVwithInputBST {

  // Runtime: 4 ms, faster than 68.65% of Java online submissions for Two Sum IV - Input is a BST.
  // Memory Usage: 42.5 MB, less than 67.86% of Java online submissions for Two Sum IV - Input is a BST.
  // my new version after one year of being on pause from learning algorithms
  public boolean findTarget(TreeNode root, int k) {
    Set<Integer> set = new HashSet<>();
    return dfs(root, k, set);
  }

  private boolean dfs(TreeNode node, int k, Set<Integer> set) {
    if (node == null) {
      return false;
    }
    if (set.contains(k - node.val)) {
      return true;
    }
    set.add(node.val);
    return dfs(node.left, k, set) || dfs(node.right, k, set);
  }


  // my old solution with runtime 34 ms and memory n/a
  public boolean findTargetV0(TreeNode root, int k) {
    List<Integer> list = new ArrayList<>();
    inOrder(root, list);
    int i = 0;
    int j = list.size() - 1;
    int sum;
    while(i < j){
      sum = list.get(i) + list.get(j);
      if (sum == k) {
        return true;
      }
      if(sum < k) {
        i++;
      } else {
        j--;
      }
    }
    return false;
  }

  public void inOrder(TreeNode root, List<Integer> list) {
    if(root != null) {
      inOrder(root.left, list);
      list.add(root.val);
      inOrder(root.right, list);
    }
  }
}
