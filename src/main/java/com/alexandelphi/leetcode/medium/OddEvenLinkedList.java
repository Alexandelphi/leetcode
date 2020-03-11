package com.alexandelphi.leetcode.medium;

public class OddEvenLinkedList {

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Odd Even Linked List.
  // Memory Usage: 41.2 MB, less than 5.00% of Java online submissions for Odd Even Linked List.
  // pointer manipulation
  public ListNode oddEvenList(ListNode head) {
    ListNode node = head;
    ListNode oddHead = null;
    ListNode oddNode = null;
    ListNode evenHead = null;
    ListNode evenNode = null;

    int indexNum = 1;
    while (node != null) {
      ListNode nextNode = node.next;
      if (indexNum % 2 != 0) { // odd
        if (oddNode == null) {
          oddHead = node;
          oddNode = node;
        } else {
          oddNode.next = node;
          oddNode = oddNode.next;
        }
      } else { // even
        if (evenNode == null) {
          evenHead = node;
          evenNode = node;
        } else {
          evenNode.next = node;
          evenNode = evenNode.next;
        }
      }
      node.next = null;
      node = nextNode;
      indexNum++;
    }
    if (oddNode != null) {
      oddNode.next = evenHead;
    }
    return oddHead;
  }
}
