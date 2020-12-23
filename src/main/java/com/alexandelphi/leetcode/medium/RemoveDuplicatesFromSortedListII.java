package com.alexandelphi.leetcode.medium;

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

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted List II.
// Memory Usage: 38.3 MB, less than 64.74% of Java online submissions for Remove Duplicates from Sorted List II.
public class RemoveDuplicatesFromSortedListII {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode curr = head;
    ListNode prev = null;
    ListNode newHead = head;
    boolean isSequence = false;
    while (curr != null) {
      while (curr.next != null && curr.val == curr.next.val) {
        isSequence = true;
        curr = curr.next;
      }
      if (isSequence) {
        isSequence = false;
        if (prev != null) {
          prev.next = curr.next;
        } else {
          newHead = curr.next;
        }
      } else {
        prev = curr; // this is a crucial moment!!! we have to update "prev" only if "isSequence == false"
      }
      curr = curr.next;
    }
    return newHead;
  }
}