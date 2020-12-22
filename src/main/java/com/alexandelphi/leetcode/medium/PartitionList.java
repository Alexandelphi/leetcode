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

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Partition List.
// Memory Usage: 38.2 MB, less than 69.59% of Java online submissions for Partition List.

public class PartitionList {
  public ListNode partition(ListNode head, int x) {
    ListNode firstPart = new ListNode(-1);  // create empty "firstPart" list with a dummy head
    ListNode firstHead = firstPart;  // remember the beginning of "firstPart" list
    ListNode secondPart = new ListNode(-1); // create empty "secondPart" list with a dummy head
    ListNode secondHead = secondPart; // remember the beginning of "secondPart" list
    ListNode curr = head; // create "curr" pointer in order to iterate through the given list

    while (curr != null) { // iterate through the given list
      if (curr.val < x) { // decide which part we should add current node
        firstPart.next = curr;
        firstPart = firstPart.next;
      } else {
        secondPart.next = curr;
        secondPart = secondPart.next;
      }
      ListNode tmpNext = curr.next; // remember "next" pointer
      curr.next = null; // once we added our node in "firstPart" or "secondPart" list, we clean "next" pointer as it might still have an old pointer in the end
      curr = tmpNext; // continue iterating in the loop by using saved "curr.next" pointer
    }

    firstPart.next = secondHead.next; // merge the end of "firstPart" list with the beginning of "secondPart" list
    return firstHead.next; // return the head of firstPart list
  }
}