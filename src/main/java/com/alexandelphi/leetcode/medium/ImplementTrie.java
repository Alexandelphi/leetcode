package com.alexandelphi.leetcode.medium;

import java.util.HashMap;
import java.util.Map;


// Runtime: 43 ms, faster than 72.79% of Java online submissions for Implement Trie (Prefix Tree).
// Memory Usage: 51 MB, less than 98.08% of Java online submissions for Implement Trie (Prefix Tree).

public class ImplementTrie {
  class TrieNode {
    private Map<Character, TrieNode> children;
    private boolean isCompleteWord;

    public TrieNode() {
      children = new HashMap<>();
      isCompleteWord = false;
    }

    public Map<Character, TrieNode> getChildren() {
      return children;
    }

    public boolean isCompleteWord() {
      return isCompleteWord;
    }

    public void setCompleteWord(boolean isCompleteWord) {
      this.isCompleteWord = isCompleteWord;
    }
  }

  private TrieNode root;

  /**
   * Initialize your data structure here.
   */
  public ImplementTrie() {
    root = new TrieNode();
  }

  /**
   * Inserts a word into the trie.
   */
  public void insert(String word) {
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      TrieNode node = current.getChildren().get(ch);
      if (node == null) {
        node = new TrieNode();
        current.getChildren().put(ch, node);
      }
      current = node;
    }
    current.setCompleteWord(true);
  }

  /**
   * Returns if the word is in the trie.
   */
  public boolean search(String word) {
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      TrieNode node = current.getChildren().get(ch);
      if (node == null) {
        return false;
      }
      current = node;
    }
    if (current.isCompleteWord()) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Returns if there is any word in the trie that starts with the given prefix.
   */
  public boolean startsWith(String prefix) {
    TrieNode current = root;
    for (int i = 0; i < prefix.length(); i++) {
      char ch = prefix.charAt(i);
      TrieNode node = current.getChildren().get(ch);
      if (node == null) {
        return false;
      }
      current = node;
    }
    return true;
  }
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new Trie();
 * obj.insert(word); boolean param_2 = obj.search(word); boolean param_3 = obj.startsWith(prefix);
 */