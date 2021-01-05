package com.alexandelphi.leetcode.easy;


// Runtime: 1 ms, faster than 99.94% of Java online submissions for Determine if String Halves Are Alike.
// Memory Usage: 37.2 MB, less than 87.39% of Java online submissions for Determine if String Halves Are Alike.
public class DetermineIfStringHalvesAreAlike {

  private static final boolean[] alikeMap = new boolean[128];

  public DetermineIfStringHalvesAreAlike() {
    char[] chars = new char[] {'a', 'e', 'i', 'o', 'u','A', 'E', 'I', 'O', 'U'};
    for (char ch : chars) {
      alikeMap[ch] = true;
    }
  }

  public boolean halvesAreAlike(String s) {
    int a = 0;
    int b = 0;
    char[] str = s.toCharArray();
    for (int i = 0; i < str.length / 2; i++) {
      if (alikeMap[str[i]] == true) {
        a++;
      }
    }
    for (int i = str.length / 2; i < str.length; i++) {
      if (alikeMap[str[i]] == true) {
        b++;
      }
    }
    return a == b;
  }
}
