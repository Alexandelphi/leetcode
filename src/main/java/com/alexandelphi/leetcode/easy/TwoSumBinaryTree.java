package com.alexandelphi.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class TwoSumBinaryTree {
  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
   * right; TreeNode(int x) { val = x; } }
   */

  // two pointers method of search
  public boolean findTarget(TreeNode root, int k) {
    List<Integer> list = new ArrayList<>();
    inOrder(root, list);
    int i = 0;
    int j = list.size() - 1;
    int sum;
    while (i < j) {
      sum = list.get(i) + list.get(j);
      if (sum == k) {
        return true;
      }
      if (sum < k) {
        i++;
      } else {
        j--;
      }
    }
    return false;
  }

  // in order binary tree traversal
  public void inOrder(TreeNode root, List<Integer> list) {
    if (root != null) {
      inOrder(root.left, list);
      list.add(root.val);
      inOrder(root.right, list);
    }
  }

  public static void main(String[] args) {
    TreeNode treeNode = new TreeNode(5);
    treeNode.insert(3);
    treeNode.insert(6);
    treeNode.insert(2);
    treeNode.insert(4);
    treeNode.insert(7);

    System.out.println(new TwoSumBinaryTree().findTarget(treeNode, 9));
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }

  public void insert(int value) {
    if (value <= val) {
      if (left == null) {
        left = new TreeNode(value);
      } else {
        left.insert(value);
      }
    } else {
      if (right == null) {
        right = new TreeNode(value);
      } else {
        right.insert(value);
      }

    }
  }

}

