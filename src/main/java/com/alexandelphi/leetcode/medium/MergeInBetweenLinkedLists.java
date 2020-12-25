package com.alexandelphi.leetcode.medium;

// Runtime: 1 ms, faster than 100.00% of Java online submissions for Merge In Between Linked Lists.
// Memory Usage: 42.7 MB, less than 86.66% of Java online submissions for Merge In Between Linked Lists.
public class MergeInBetweenLinkedLists {
  public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
    ListNode list1Head = list1;
    ListNode list1APrev = null;
    ListNode list1BNext = null;
    ListNode curr = list1;
    ListNode prev = null;
    int i = 0;
    while (list1BNext == null) {
      if (i == a) {
        list1APrev = prev;
      }
      if (i == b) {
        list1BNext = curr.next;
      }
      i++;
      prev = curr;
      curr = curr.next;
    }
    ListNode list2Head = list2;
    ListNode list2Tail = null;
    curr = list2;
    while (curr != null) {
      list2Tail = curr;
      curr = curr.next;
    }
    list1APrev.next = list2Head;
    list2Tail.next = list1BNext;
    return list1Head;
  }
}
