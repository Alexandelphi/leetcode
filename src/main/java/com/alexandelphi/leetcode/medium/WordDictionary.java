package com.alexandelphi.leetcode.medium;

import java.util.HashMap;
import java.util.Map;


// Runtime: 48 ms, faster than 47.97% of Java online submissions for Add and Search Word - Data structure design.
// Memory Usage: 55.3 MB, less than 81.82% of Java online submissions for Add and Search Word - Data structure design.
// quite interesting task, solved by using Trie + Backtracking

class WordDictionary {
  private class TrieNode {
    public Map<Character, TrieNode> children;
    public boolean isCompleted;

    public TrieNode() {
      children = new HashMap<>();
      isCompleted = false;
    }
  }

  private TrieNode root;

  /**
   * Initialize your data structure here.
   */
  public WordDictionary() {
    root = new TrieNode();
  }

  /**
   * Adds a word into the data structure.
   */
  public void addWord(String word) {
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      TrieNode node = current.children.get(ch);
      if (node == null) {
        node = new TrieNode();
        current.children.put(ch, node);
      }
      current = node;
    }
    current.isCompleted = true;
  }

  /**
   * Returns if the word is in the data structure. A word could contain the dot character '.' to
   * represent any one letter.
   */
  public boolean search(String word) {
    return backtrackSearch(word, root, 0);
  }

  private boolean backtrackSearch(String word, TrieNode node, int index) {
    if (index != 0 && word.length() == index) {
      return node.isCompleted == true;
    }
    TrieNode curr = node;
    for (int i = index; i < word.length(); i++) {
      char ch = word.charAt(i);
      if (ch == '.') {
        int countOfFoundNodes = 0;
        for (char c = 'a'; c <= 'z'; c++) {
          TrieNode foundNode = curr.children.get(c);
          if (foundNode == null) {
            continue;
          }
          if (backtrackSearch(word, foundNode, i + 1)) {
            countOfFoundNodes++;
          }
        }
        return countOfFoundNodes > 0;
      } else {
        TrieNode foundNode = curr.children.get(ch);
        if (foundNode == null) {
          return false;
        }
        curr = foundNode;
      }
    }
    return curr.isCompleted;
  }

  /**
   * Your WordDictionary object will be instantiated and called as such:
   * WordDictionary obj = new WordDictionary();
   * obj.addWord(word);
   * boolean param_2 = obj.search(word);
   */


  public static void main(String[] args) {
    WordDictionary wd = new WordDictionary();
    wd.addWord("an");
    wd.addWord("ba");
    System.out.println(wd.search(".a"));
  }

}
