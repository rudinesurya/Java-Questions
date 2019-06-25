package DataStructure;

public class Trie {

  TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  public void insert(String word) {
    TrieNode p = root;
    for (int i = 0; i < word.length(); ++i) {
      char c = word.charAt(i);
      int index = c - 'a';
      if (p.children[index] == null) {
        p.children[index] = new TrieNode();
      }

      p = p.children[index];
      p.np += 1;
    }
    p.hasEnd = true;
  }

  public int find(String prefix) {
    TrieNode p = root;
    for (int i = 0; i < prefix.length(); ++i) {
      char c = prefix.charAt(i);
      int index = c - 'a';
      if (p.children[index] == null) {
        return 0;
      } else {
        p = p.children[index];
      }
    }

    return p.np;
  }

  class TrieNode {

    public TrieNode[] children = new TrieNode[26];
    public boolean hasEnd;
    public int np;

    public TrieNode() {
    }
  }
}
