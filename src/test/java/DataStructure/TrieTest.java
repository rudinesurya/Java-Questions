package DataStructure;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TrieTest {

  @Test
  void simple() {
    Trie trie = new Trie();
    trie.insert("john");
    trie.insert("johnson");

    int num = trie.find("john");
    assertEquals(2, num);
  }

  @Test
  void simple2() {
    Trie trie = new Trie();
    trie.insert("john");
    trie.insert("johnson");

    int num = trie.find("johns");
    assertEquals(1, num);
  }

  @Test
  void doesntExist() {
    Trie trie = new Trie();
    trie.insert("john");
    trie.insert("johnson");

    int num = trie.find("mary");
    assertEquals(0, num);
  }
}
