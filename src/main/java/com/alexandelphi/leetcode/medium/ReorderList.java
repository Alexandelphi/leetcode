package com.alexandelphi.leetcode.medium;

import java.util.HashMap;
import java.util.Map;


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


public class ReorderList {

  // Runtime: 5 ms, faster than 12.37% of Java online submissions for Reorder List.
  // Memory Usage: 42.3 MB, less than 62.52% of Java online submissions for Reorder List.
  // Time - O(n), Space - O(n)
  public void reorderList(ListNode head) {
    if (head == null) {
      return;
    }
    Map<Integer, ListNode> map = new HashMap<>();
    ListNode node = head;
    int n = 0;
    while (node != null) {
      map.put(n, node);
      n++;
      node = node.next;
    }
    int i = 1;
    int j = n - 1;
    boolean isReversedElem = true;
    node = head;
    while (i <= j) {
      ListNode curr = null;
      if (isReversedElem) {
        curr = map.get(j);
        j--;
        isReversedElem = false;
      } else {
        curr = map.get(i);
        i++;
        isReversedElem = true;
      }
      node.next = curr;
      node = node.next;
    }
    node.next = null;
  }

  // Runtime: 1 ms, faster than 99.94% of Java online submissions for Reorder List.
  // Memory Usage: 42.4 MB, less than 55.31% of Java online submissions for Reorder List.
  // Time - O(n), Space - O(1)
  public void reorderListV2(ListNode head) {
    if (head == null) return;
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode slowNode = slow;
    ListNode revHead = null;
    while (slowNode != null) {
      ListNode node = slowNode;
      slowNode = slowNode.next;
      node.next = revHead;
      revHead = node;
    }

    ListNode first = head;
    ListNode second = revHead;
    while (second.next != null) {
      ListNode temp = first.next;
      first.next = second;
      first = temp;

      temp = second.next;
      second.next = first;
      second = temp;
    }
  }
}