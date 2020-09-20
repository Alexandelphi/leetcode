package com.alexandelphi.leetcode.easy;


// Runtime: 34 ms, faster than 29.76% of Java online submissions for Prime Number of Set Bits in Binary Representation.
// Memory Usage: 36.4 MB, less than 62.91% of Java online submissions for Prime Number of Set Bits in Binary Representation.
public class PrimeNumberOfSetBitsInBinaryRepresentation {
  public int countPrimeSetBits(int L, int R) {
    int primeSetBits = 0;
    for (int i = L; i <= R; i++) {
      int bits = numOfBits(i);
      if (isPrime(bits)) {
        primeSetBits++;
      }
    }
    return primeSetBits;
  }

  private int numOfBits(int num) {
    int count = 0;
    for (int i = 0; i < 32; i++) {
      if ((num & 1) == 1) {
        count++;
      }
      num >>= 1;
    }
    return count;
  }

  private boolean isPrime(int num) {
    if (num <= 2) {
      return num == 2;
    } else if (num % 2 != 0) {
      for (int i = 3; i <= Math.sqrt(num); i++) {
        if (num % i == 0) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
}