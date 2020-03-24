package com.alexandelphi.leetcode.easy;

import java.util.ArrayDeque;
import java.util.Queue;

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Implement Stack using Queues.
// Memory Usage: 37.6 MB, less than 6.67% of Java online submissions for Implement Stack using Queues.
public class ImplementStackUsingQueues {
  Queue<Integer> queue = new ArrayDeque<>();

  /** Initialize your data structure here. */
  public ImplementStackUsingQueues() {

  }

  /** Push element x onto stack. */
  public void push(int x) {
    queue.add(x);
    for (int i = 1; i < queue.size(); i++) {
      queue.add(queue.remove());
    }
  }

  /** Removes the element on top of the stack and returns that element. */
  public int pop() {
    return queue.poll();
  }

  /** Get the top element. */
  public int top() {
    return queue.peek();
  }

  /** Returns whether the stack is empty. */
  public boolean empty() {
    return queue.isEmpty();
  }
}
