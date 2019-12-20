package com.alexandelphi.leetcode.easy;

public class ConvertBinaryNumberInALinkedListToInteger {
  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Binary Number in a Linked List to Integer.
  // Memory Usage: 34.3 MB, less than 100.00% of Java online submissions for Convert Binary Number in a Linked List to Integer.
  public int getDecimalValue(ListNode head) {
    ListNode node = head;
    int index = 0;
    int result = 0;
    while (node != null) {
      index++;
      node = node.next;
    }
    node = head;
    while (node != null) {
      index--;
      result += node.val * Math.pow(2, index);
      node = node.next;
    }
    return result;
  }

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Binary Number in a Linked List to Integer.
  // Memory Usage: 34.4 MB, less than 100.00% of Java online submissions for Convert Binary Number in a Linked List to Integer.
  public int getDecimalValueV2(ListNode head) {
    ListNode node = head;
    int result = 0;
    while (node != null) {
      result = result << 1;
      result += node.val;
      node = node.next;
    }
    return result;
  }
}

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
