package com.alexandelphi.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {

  // Runtime: 18 ms, faster than 45.80% of Java online submissions for Find Duplicate Subtrees.
  // Memory Usage: 47.5 MB, less than 100.00% of Java online submissions for Find Duplicate Subtrees.
  // dfs pre-order traversal + hash map
  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    List<TreeNode> result = new ArrayList<>();
    dfs(root, new HashMap<>(), result);
    return result;
  }

  private String dfs(TreeNode node, Map<String, Integer> map, List<TreeNode> result) {
    if (node == null) {
      return "";
    }
    String str = node.val + "," + dfs(node.left, map, result) + "," + dfs(node.right, map, result);
    if(map.getOrDefault(str, 0) == 1) {
      result.add(node);
    }
    map.put(str, map.getOrDefault(str, 0) + 1);
    return str;
  }
}
