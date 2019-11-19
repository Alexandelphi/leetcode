package com.alexandelphi.leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Implement Queue using Stacks.
// Memory Usage: 34.3 MB, less than 20.83% of Java online submissions for Implement Queue using Stacks.

public class ImplementQueueUsingStacks {

}

class MyQueue {
  private Deque<Integer> pushStack;
  private Deque<Integer> popStack;

  /**
   * Initialize your data structure here.
   */
  public MyQueue() {
    pushStack = new ArrayDeque<>();
    popStack = new ArrayDeque<>();
  }

  /**
   * Push element x to the back of queue.
   */
  public void push(int x) {
    pushStack.push(x);
  }

  /**
   * Removes the element from in front of queue and returns that element.
   */
  public int pop() {
    if (!popStack.isEmpty()) {
      return popStack.pop();
    } else {
      while (!pushStack.isEmpty()) {
        popStack.push(pushStack.pop());
      }
      return popStack.pop();
    }
  }

  /**
   * Get the front element.
   */
  public int peek() {
    if (!popStack.isEmpty()) {
      return popStack.peek();
    } else {
      while (!pushStack.isEmpty()) {
        popStack.push(pushStack.pop());
      }
      return popStack.peek();
    }
  }

  /**
   * Returns whether the queue is empty.
   */
  public boolean empty() {
    return pushStack.isEmpty() & popStack.isEmpty();
  }
}

/**
 * Your MyQueue object will be instantiated and called as such: MyQueue obj = new MyQueue();
 * obj.push(x); int param_2 = obj.pop(); int param_3 = obj.peek(); boolean param_4 = obj.empty();
 */
