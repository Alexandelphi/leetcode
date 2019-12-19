package com.alexandelphi.leetcode.medium;

public class PrintImmutableLinkedListInReverse {

  // Runtime: 1 ms, faster than 100.00% of Java online submissions for Print Immutable Linked List in Reverse.
  // Memory Usage: 35.8 MB, less than 100.00% of Java online submissions for Print Immutable Linked List in Reverse.
  public void printLinkedListInReverse(ImmutableListNode head) {
    if (head == null) {
      return;
    }
    printLinkedListInReverse(head.getNext());
    head.printValue();
  }
}

interface ImmutableListNode {
  public void printValue();
  public ImmutableListNode getNext();
}

/**
 * // This is the ImmutableListNode's API interface.
 * // You should not implement it, or speculate about its implementation.
 * interface ImmutableListNode {
 *     public void printValue(); // print the value of this node.
 *     public ImmutableListNode getNext(); // return the next node.
 * };
 */
