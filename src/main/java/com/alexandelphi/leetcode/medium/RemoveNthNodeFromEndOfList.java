package com.alexandelphi.leetcode.medium;

public class RemoveNthNodeFromEndOfList {

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Nth Node From End of List.
  // Memory Usage: 35.1 MB, less than 100.00% of Java online submissions for Remove Nth Node From End of List.
  // my solution with DummyHead, it can be improved...
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummyHead = new ListNode(-1);
    dummyHead.next = head;
    ListNode node = head;
    int length = 0;
    while (node != null) {
      length++;
      node = node.next;
    }
    length -= n;
    node = dummyHead;
    while (length > 0) {
      node = node.next;
      length--;
    }
    node.next = node.next.next;
    return dummyHead.next;
  }
}
