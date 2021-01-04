package com.alexandelphi.leetcode.hard;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Nodes in k-Group.
// Memory Usage: 39.5 MB, less than 28.72% of Java online submissions for Reverse Nodes in k-Group.

public class ReverseNodesInKGroup {

  private ListNode curr = null;

  public ListNode reverseKGroup(ListNode head, int k) {
    curr = head;
    int count = getLength(head) / k;
    ListNode newHead = null;
    ListNode newTail = null;
    while (count > 0) {
      ListNode[] reversedNodes = reverseKNodes(curr, k);
      if (newHead == null) {
        newHead = reversedNodes[0];
      } else {
        newTail.next = reversedNodes[0];
      }
      newTail = reversedNodes[1];
      count--;
    }
    newTail.next = curr;
    return newHead;
  }

  private ListNode[] reverseKNodes(ListNode node, int k) {
    ListNode newHead = null;
    ListNode newTail = null;
    while (node != null && k > 0) {
      ListNode tmpNext = node.next;
      node.next = newHead;
      newHead = node;
      if (newTail == null) {
        newTail = newHead;
      }
      node = tmpNext;
      k--;
    }
    curr = node;
    return new ListNode[] {newHead, newTail};
  }

  private int getLength(ListNode node) {
    int i = 0;
    while (node != null) {
      i++;
      node = node.next;
    }
    return i;
  }
}