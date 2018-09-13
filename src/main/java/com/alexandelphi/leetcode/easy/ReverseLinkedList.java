package com.alexandelphi.leetcode.easy;

public class ReverseLinkedList {

  private class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode reverseList(ListNode list) {
    ListNode newList = null;
    while (list != null) {
      ListNode temp = list.next; // copy pointer of second element to temp
      // Iter1: temp = 2->3->4->5->null, list = 1->2->3->4->5->null, newList = null
      // Iter2: temp = 3->4->5->null, list = 2->3->4->5->null, newList = 1->null
      // Iter3: temp = 4->5->null, list = 3->4->5->null, newList = 2->1->null
      // Iter4: temp = 5->null, list = 4->5->null, newList = 3->2->1->null
      // Iter5: temp = null, list = 5->null, newList = 4->3->2->1->null
      list.next = newList; // replace pointer of second element to newList (it's empty at first)
      // Iter1: temp = 2->3->4->5->null, list = 1->null, newList = null
      // Iter2: temp = 3->4->5->null, list = 2->1->null, newList = 1->null
      // Iter3: temp = 4->5->null, list = 3->2->1->null, newList = 2->1->null
      // Iter4: temp = 5->null, list = 4->3->2->1->null, newList = 3->2->1->null
      // Iter5: temp = null, list = 5->4->3->2->1->null, newList = 4->3->2->1->null
      newList = list; // empty newList is getting the pointer of first/head element of list
      // Iter1: temp = 2->3->4->5->null, list = 1->null, newList = 1->null
      // Iter2: temp = 3->4->5->null, list = 2->1->null, newList = 2->1->null
      // Iter3: temp = 4->5->null, list = 3->2->1->null, newList = 3->2->1->null
      // Iter4: temp = 5->null, list = 4->3->2->1->null, newList = 4->3->2->1->null
      // Iter5: temp = null, list = 5->4->3->2->1->null, newList = 5->4->3->2->1->null
      list = temp; // iterate the list, getting next element for the loop, the same as list = list.next
      // Iter1: temp = 2->3->4->5->null, list = 2->3->4->5->null, newList = 1->null
      // Iter2: temp = 3->4->5->null, list = 3->4->5->null, newList = 2->1->null
      // Iter3: temp = 4->5->null, list = 4->5->null, newList = 3->2->1->null
      // Iter4: temp = 5->null, list = 5->null, newList = 4->3->2->1->null
      // Iter5: temp = null, list = null, newList = 5->4->3->2->1->null
    }
    return newList;
  }
}
