package com.alexandelphi.leetcode.medium;

import java.util.ArrayList;
import java.util.List;


//    Runtime: 1 ms, faster than 100.00% of Java online submissions for Path Sum II.
//    Memory Usage: 37.5 MB, less than 100.00% of Java online submissions for Path Sum II.
//    my optimized solution
public class PathSumII {
  private List<List<Integer>> result = new ArrayList<>();
  private int target;

  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    this.target = sum;
    helperDFS(root, new ArrayList<Integer>(), 0);
    return result;
  }

  private void helperDFS(TreeNode node, List<Integer> list, int sum) {
    if (node == null) {
      return;
    }
    sum += node.val;
    list.add(node.val);
    if (node.left == null && node.right == null && sum == target) {
      result.add(new ArrayList<>(list));
    }
    if (node.left != null) helperDFS(node.left, list, sum);
    if (node.right != null) helperDFS(node.right, list, sum);
    list.remove(list.size() - 1);
  }
}
