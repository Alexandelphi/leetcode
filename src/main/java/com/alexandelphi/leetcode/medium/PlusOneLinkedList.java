package com.alexandelphi.leetcode.medium;

public class PlusOneLinkedList {
  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Plus One Linked List.
  // Memory Usage: 34.4 MB, less than 100.00% of Java online submissions for Plus One Linked List.
  // my straightforward solution
  public ListNode plusOne(ListNode head) {
    if (helper(head) > 0) {
      ListNode newHead = new ListNode(1);
      newHead.next = head;
      return newHead;
    }
    return head;
  }

  private int helper(ListNode node) {
    if (node == null) {
      return 1;
    }
    node.val += helper(node.next);
    if (node.val > 9) {
      node.val = 0;
      return 1;
    }
    return 0;
  }
}
