package com.alexandelphi.leetcode.medium;

public class SplitLinkedListInParts {

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Split Linked List in Parts.
  // Memory Usage: 39.5 MB, less than 7.69% of Java online submissions for Split Linked List in Parts.
  // my solution where we have two main cases
  // 1) we have to keep extra size which will use for adding extra one element to list
  // 2) we have to track prev element in order to split into separate lists equally
  public ListNode[] splitListToParts(ListNode root, int k) {
    int length = 0;
    ListNode node = root;
    while (node != null) {
      length++;
      node = node.next;
    }

    int initSize = length / k;
    int extraSize = length % k;
    if (initSize < 1) {
      initSize = 1;
      extraSize = 0;
    }
    ListNode[] result = new ListNode[k];
    node = root;
    for (int i = 0; i < k; i++) {
      ListNode newHead = node;
      ListNode prevNode = null;
      int extraOnePlace = 0;
      if (extraSize > 0) {
        extraOnePlace = 1;
        extraSize--;
      }
      for (int j = 0; node != null && j < initSize + extraOnePlace; j++) {
        prevNode = node;
        node = node.next;
      }
      if (node != null) {
        prevNode.next = null;
      }
      result[i] = newHead;
    }
    return result;
  }
}
