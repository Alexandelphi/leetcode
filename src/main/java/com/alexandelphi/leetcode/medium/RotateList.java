package com.alexandelphi.leetcode.medium;

public class RotateList {
  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Search a 2D Matrix.
  // Memory Usage: 39 MB, less than 65.64% of Java online submissions for Search a 2D Matrix.
  // Time O(n) and Space O(1);

  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || k == 0) {
      return head;
    }
    int n = 0;
    ListNode node = head;
    while (node != null) {
      n++;
      node = node.next;
    }
    k = k % n;
    if (k == 0) {
      return head;
    }
    ListNode firstHalf = head;
    ListNode secondHalf = null;
    node = head;
    for (int i = 0; i < n - k - 1; i++) {
      node = node.next;
    }
    secondHalf = node.next;
    ListNode secondHalfTail = secondHalf;
    while (secondHalfTail.next != null) {
      secondHalfTail = secondHalfTail.next;
    }
    node.next = null;
    secondHalfTail.next = firstHalf;
    return secondHalf;
  }
}
