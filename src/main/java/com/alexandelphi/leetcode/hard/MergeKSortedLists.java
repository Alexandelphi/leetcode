package com.alexandelphi.leetcode.hard;

import java.util.PriorityQueue;

public class MergeKSortedLists {

  //  Runtime: 6 ms, faster than 50.55% of Java online submissions for Merge k Sorted Lists.
  //  Memory Usage: 44.1 MB, less than 24.05% of Java online submissions for Merge k Sorted Lists.
  public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (ListNode node : lists) {
      while (node != null) {
        pq.add(node.val);
        node = node.next;
      }
    }
    ListNode head = null;
    ListNode newNode = null;
    while (!pq.isEmpty()) {
      int value = pq.remove();
      if (newNode == null) {
        newNode = new ListNode(value);
        head = newNode;
      } else {
        newNode.next = new ListNode(value);
        newNode = newNode.next;
      }
    }
    return head;
  }
}

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}

