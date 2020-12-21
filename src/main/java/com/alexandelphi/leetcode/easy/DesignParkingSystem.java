package com.alexandelphi.leetcode.easy;

public class DesignParkingSystem {
}
// Runtime: 6 ms, faster than 99.74% of Java online submissions for Design Parking System.
// Memory Usage: 39.9 MB, less than 38.68% of Java online submissions for Design Parking System.
class ParkingSystem {

  private int big;
  private int medium;
  private int small;

  public ParkingSystem(int big, int medium, int small) {
    this.big = big;
    this.medium = medium;
    this.small = small;
  }

  public boolean addCar(int carType) {
    switch(carType) {
      case 1: if (big > 0) {big--; return true;} break;
      case 2: if (medium > 0) {medium--; return true;} break;
      case 3: if (small > 0) {small--; return true;} break;
    }
    return false;
  }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */