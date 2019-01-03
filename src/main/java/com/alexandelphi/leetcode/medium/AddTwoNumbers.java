package com.alexandelphi.leetcode.medium;

// not so elegant solution but I did it on my own

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}

class AddTwoNumbers {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    return printListNode(l1, l2);
  }

  private ListNode printListNode(ListNode l1, ListNode l2) {
    ListNode tail = null;
    ListNode result = null;
    boolean nextPlusOne = false;

    while (l1 != null || l2 != null || nextPlusOne) {
      int value1 = 0;
      int value2 = 0;
      int sum = 0;

      if (l1 != null) {
        value1 = l1.val;
        l1 = l1.next;
      } else {
        value1 = 0;
      }

      if (l2 != null) {
        value2 = l2.val;
        l2 = l2.next;
      } else {
        value2 = 0;
      }
      if (nextPlusOne) {
        sum = value1 + value2 + 1;
      } else {
        sum = value1 + value2;
      }

      if (sum >= 10) {
        nextPlusOne = true;
        sum = sum % 10;
      } else {
        nextPlusOne = false;
      }

      if (result == null) {
        result = new ListNode(sum);
        tail = result;
      } else {
        result.next = new ListNode(sum);
        result = result.next;
      }
    }
    return tail;
  }
}
