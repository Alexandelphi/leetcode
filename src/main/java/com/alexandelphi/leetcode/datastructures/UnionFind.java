package com.alexandelphi.leetcode.datastructures;

// Disjoint Set - Union Find
public class UnionFind {

  // The number of elements in this union find
  private int size;

  // id[i] points to the parent of i, if id[i] = i then i is a root node
  private int[] id;

  // Used to track the sizes of each of the components
  private int[] sz;

  // Tracks the number of components in the union find
  private int numComponents;

  public UnionFind(int size) {
    if (size <= 0) {
      throw new IllegalArgumentException("size <= 0 is not allowed");
    }
    this.size = numComponents = size;
    id = new int[size];
    sz = new int[size];

    for (int i = 0; i < size; i++) {
      id[i] = i;
      sz[i] = 1;
    }
  }
}
