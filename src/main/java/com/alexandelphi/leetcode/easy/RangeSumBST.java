package com.alexandelphi.leetcode.easy;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class RangeSumBST {
  /**
   * My First solution
   * Runtime: 1 ms, faster than 52.60% of Java online submissions for Range Sum of BST.
   * Memory Usage: 44.7 MB, less than 98.03% of Java online submissions for Range Sum of BST.
   */

  public int rangeSumBST(TreeNode root, int L, int R) {
    int internalSum = 0;
    if (root == null) {
      return 0;
    } else {
      if (root.val >= L && root.val <= R) {
        internalSum += root.val;
      }
      internalSum += rangeSumBST(root.left, L, R);
      internalSum += rangeSumBST(root.right, L, R);
    }
    return internalSum;
  }

  /**
   * My Second solution after checking BUDs (bottlenecks, unnecessary work, duplicated work)
   * I have found that we can use BST properties for removing unnecessary work in the logic,
   * we shouldn't check Nodes which lower than L and greater than R, and we have Binary Search Tree,
   * all of these mean that we can avoid unnecessary work.
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Range Sum of BST.
   * Memory Usage: 44.5 MB, less than 98.41% of Java online submissions for Range Sum of BST.
   */

   public int optimizedRangeSumBST(TreeNode root, int L, int R) {
    if (root == null) {
      return 0;
    } else {
      if (root.val < L) {
        return rangeSumBST(root.right, L, R);
      } else if (root.val > R) {
        return rangeSumBST(root.left, L, R);
      } else {
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
      }
    }
  }

}