package com.alexandelphi.leetcode.easy;

public class PrintInOrder {
}
// Runtime: 9 ms, faster than 79.00% of Java online submissions for Print in Order.
// Memory Usage: 36.3 MB, less than 100.00% of Java online submissions for Print in Order.

class Foo {

  private boolean firstShown;
  private boolean secondShown;

  public Foo() {
    firstShown = false;
    secondShown = false;
  }

  public synchronized void first(Runnable printFirst) throws InterruptedException {
    // printFirst.run() outputs "first". Do not change or remove this line.
    printFirst.run();
    firstShown = true;
    notifyAll();
  }

  public synchronized void second(Runnable printSecond) throws InterruptedException {
    while (!firstShown) {
      wait();
    }
    // printSecond.run() outputs "second". Do not change or remove this line.
    printSecond.run();
    secondShown = true;
    notifyAll();
  }

  public synchronized void third(Runnable printThird) throws InterruptedException {
    while (!secondShown) {
      wait();
    }
    // printThird.run() outputs "third". Do not change or remove this line.
    printThird.run();
  }
}