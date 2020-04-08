package com.alexandelphi.leetcode.easy;


// Runtime: 0 ms, faster than 100.00% of Java online submissions for Middle of the Linked List.
// Memory Usage: 37.5 MB, less than 7.84% of Java online submissions for Middle of the Linked List.
// first we count the length of the list, then we search for out listnode
// also, we can use slow / fast approach (Floyd's Tortoise and Hare / Floyd's Cycle Detection Algorithm)
public class MiddleOfTheLinkedList {
  public ListNode middleNode(ListNode head) {
    int n = 0;
    ListNode node = head;
    while (node != null) {
      n++;
      node = node.next;
    }
    node = head;
    for (int i = 0; i < n / 2; i++) {
      node = node.next;
    }
    return node;
  }
}
