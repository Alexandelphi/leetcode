package com.alexandelphi.leetcode.easy;

public class DeleteNNodesAfterMNodesOfALinkedList {
  // Runtime: 1 ms, faster than 54.24% of Java online submissions for Delete N Nodes After M Nodes of a Linked List.
  // Memory Usage: 48.5 MB, less than 10.32% of Java online submissions for Delete N Nodes After M Nodes of a Linked List.
  // Time O(n) and Space O(1) complexity
  public ListNode deleteNodes(ListNode head, int m, int n) {
    ListNode curr = head;
    ListNode prev = null;
    while (curr != null) {
      for (int i = 0; i < m && curr != null; i++) {
        prev = curr;
        curr = curr.next;
      }
      for (int i = 0; i < n && curr != null; i++) {
        curr = curr.next;
      }
      prev.next = curr;
    }
    return head;
  }
}
