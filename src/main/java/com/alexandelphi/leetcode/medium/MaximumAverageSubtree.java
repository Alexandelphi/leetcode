package com.alexandelphi.leetcode.medium;

// Runtime: 2 ms, faster than 17.61% of Java online submissions for Maximum Average Subtree.
// Memory Usage: 41.9 MB, less than 100.00% of Java online submissions for Maximum Average Subtree.
// Here is my naive solution and we can see that it can be optimised, because
// this solution has O(n + n*log(n)) -> O(n*log(n)) time complexity
// Please check optimised version below
public class MaximumAverageSubtree {
  public double maximumAverageSubtree(TreeNode root) {
    return findMax(root);
  }

  private double findMax(TreeNode node) {
    if (node == null) {
      return 0;
    }
    double currMax = getAvg(node);
    double left = findMax(node.left);
    double right = findMax(node.right);
    return Math.max(currMax, Math.max(left, right));
  }

  private double getAvg(TreeNode node) {
    int[] numOfNodes = new int[1]; // pointer value
    numOfNodes[0] = 0;
    return dfsSum(node, numOfNodes) / numOfNodes[0];
  }

  private double dfsSum(TreeNode node, int[] numOfNodes) {
    if (node == null) {
      return 0;
    }
    numOfNodes[0]++;
    return node.val + dfsSum(node.left, numOfNodes) + dfsSum(node.right, numOfNodes);
  }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Average Subtree.
// Memory Usage: 41.8 MB, less than 100.00% of Java online submissions for Maximum Average Subtree.
// optimized version with O(n) time complexity
class MaximumAverageSubtreeV2 {
  private double result;

  public double maximumAverageSubtree(TreeNode root) {
    findAvg(root);
    return result;
  }
  // {num of nodes, sum}
  private int[] findAvg(TreeNode node) {
    if (node == null) {
      return new int[]{0, 0};
    }
    int[] left = findAvg(node.left);
    int[] right = findAvg(node.right);
    int numOfNodes = left[0] + right[0] + 1;
    int sum = left[1] + right[1] + node.val;
    result = Math.max(result, (double) sum / numOfNodes);
    return new int[]{numOfNodes, sum};
  }
}
