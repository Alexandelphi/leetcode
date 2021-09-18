package com.alexandelphi.leetcode.medium;

// Solved by using DisjointSet(DSU or UnionFind) data structure
// with path compression + union by rank optimizations.

public class GraphValidTree {
  public boolean validTree(int n, int[][] edges) {
    DisjointSet ds = new DisjointSet(n);
    for (int[] edge : edges) {
      if (ds.connected(edge[0], edge[1])) {
        return false;
      }
      ds.union(edge[0], edge[1]);
    }
    return n - 1 == edges.length;
  }

  private class DisjointSet {
    private final int[] root;
    private final int[] rank;

    public DisjointSet(int size) {
      root = new int[size];
      rank = new int[size];
      for (int i = 0; i < size; i++) {
        root[i] = i;
        rank[i] = 1;
      }
    }

    public int find(int x) {
      if (root[x] == x) {
        return x;
      }
      // path compression
      return root[x] = find(root[x]);
    }

    public void union(int x, int y) {
      int rootX = find(x);
      int rootY = find(y);
      if (rootX == rootY) return;

      // union by rank
      if (rank[rootX] > rank[rootY]) {
        root[rootY] = rootX;
      } else if (rank[rootX] < rank[rootY]) {
        root[rootX] = rootY;
      } else {
        root[rootY] = rootX;
        rank[rootX] += 1;
      }
    }

    public boolean connected(int x, int y) {
      return find(x) == find(y);
    }
  }
}
