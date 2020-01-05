package com.alexandelphi.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class LetterTilePossibilities {


  // Runtime: 34 ms, faster than 17.39% of Java online submissions for Letter Tile Possibilities.
  // Memory Usage: 41 MB, less than 100.00% of Java online submissions for Letter Tile Possibilities.
  // backtracking solution with no string builder yet :-)
  public int numTilePossibilities(String tiles) {
    Set<String> result = new HashSet<>();
    backtrack(result, "", tiles, new boolean[tiles.length()]);
    return result.size();
  }

  private void backtrack(Set<String> result, String str, String tiles, boolean[] usedIndices) {
    if (str.length() > 0) {
      result.add(str);
    }
    for (int i = 0; i < tiles.length();  i++) {
      if (usedIndices[i] == true) continue;
      str += tiles.charAt(i);
      usedIndices[i] = true;
      backtrack(result, str, tiles, usedIndices);
      str = str.substring(0, str.length() - 1);
      usedIndices[i] = false;
    }
  }

  // Runtime: 28 ms, faster than 27.20% of Java online submissions for Letter Tile Possibilities.
  // Memory Usage: 39.9 MB, less than 100.00% of Java online submissions for Letter Tile Possibilities.
  // slightly improved version with string builder
  public int numTilePossibilitiesV2(String tiles) {
    Set<String> result = new HashSet<>();
    backtrackV2(result, new StringBuilder(), tiles, new boolean[tiles.length()]);
    return result.size();
  }

  private void backtrackV2(Set<String> result, StringBuilder sb, String tiles, boolean[] usedIndices) {
    if (sb.length() > 0) {
      result.add(sb.toString());
    }
    for (int i = 0; i < tiles.length();  i++) {
      if (usedIndices[i] == true) continue;
      sb.append(tiles.charAt(i));
      usedIndices[i] = true;
      backtrackV2(result, sb, tiles, usedIndices);
      // Note: here we don't do "sb.length() > 0" check, because we add an element first then remove,
      // and we can be sure that before removing, we have at at least 1 element in StringBuilder
      sb.setLength(sb.length() - 1);
      usedIndices[i] = false;
    }
  }
}
