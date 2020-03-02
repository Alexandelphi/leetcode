package com.alexandelphi.leetcode.medium;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {
  public Node cloneGraph(Node node) {
    return bfs(node);
  }

  // Runtime: 52 ms, faster than 5.28% of Java online submissions for Clone Graph.
  // Memory Usage: 41 MB, less than 5.88% of Java online submissions for Clone Graph.
  // my bfs solution
  private Node bfs(Node node) {
    if (node == null) return null;
    Map<Integer, Node> map = new HashMap<>();
    Queue<Node> queue = new ArrayDeque<>(); // ArrayDeque
    queue.add(node);
    map.put(node.val, new Node(node.val));
    while (!queue.isEmpty()) {
      Node curr = queue.poll();
      for (Node w : curr.neighbors) {
        if (!map.containsKey(w.val)) {
          map.put(w.val, new Node(w.val));
          queue.add(w);
        }
        map.get(curr.val).neighbors.add(map.get(w.val));
      }
    }
    return map.get(node.val);
  }

  // Runtime: 26 ms, faster than 76.50% of Java online submissions for Clone Graph.
  // Memory Usage: 38.8 MB, less than 5.88% of Java online submissions for Clone Graph.
  // another bfs version with LinkedList is faster for this LC task
  private Node bfsV2(Node node) {
    if (node == null) return null;
    Map<Integer, Node> map = new HashMap<>();
    Queue<Node> queue = new LinkedList<>(); // LinkedList
    queue.add(node);
    map.put(node.val, new Node(node.val));
    while (!queue.isEmpty()) {
      Node curr = queue.poll();
      for (Node w : curr.neighbors) {
        if (!map.containsKey(w.val)) {
          map.put(w.val, new Node(w.val));
          queue.add(w);
        }
        map.get(curr.val).neighbors.add(map.get(w.val));
      }
    }
    return map.get(node.val);
  }
}


// Runtime: 28 ms, faster than 41.00% of Java online submissions for Clone Graph.
// Memory Usage: 39.1 MB, less than 5.88% of Java online submissions for Clone Graph.
// my dfs solution
class DfsSolution {
  public Node cloneGraph(Node node) {
    Map<Integer, Node> map = new HashMap<>();
    return dfs(node, map);
  }

  private Node dfs(Node node, Map<Integer, Node> map) {
    if (node == null) return null;
    if (map.containsKey(node.val)) {
      return map.get(node.val);
    }
    Node copy = new Node(node.val);
    map.put(copy.val, copy);
    for (Node w : node.neighbors) {
      copy.neighbors.add(dfs(w, map));
    }
    return copy;
  }
}

class Node {
  public int val;
  public List<Node> neighbors;

  public Node() {
    val = 0;
    neighbors = new ArrayList<Node>();
  }

  public Node(int _val) {
    val = _val;
    neighbors = new ArrayList<Node>();
  }

  public Node(int _val, ArrayList<Node> _neighbors) {
    val = _val;
    neighbors = _neighbors;
  }
}
