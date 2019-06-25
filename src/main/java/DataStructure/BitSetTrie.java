package DataStructure;

import java.util.BitSet;

//used for fast find all matching bitset pair which sum up to a full bitset
//eg. bit 1101 requires any pair which has bit 0010 set.

public class BitSetTrie {

  TrieNode root = new TrieNode();

  public void add(BitSet bitFlag) {
    TrieNode currentNode = root;
    for (int i = 0; i < 10; ++i) {
      if (bitFlag.get(i)) {
        if (currentNode.present == null) {
          currentNode.present = new TrieNode();
        }
        currentNode = currentNode.present;
      } else {
        if (currentNode.absent == null) {
          currentNode.absent = new TrieNode();
        }
        currentNode = currentNode.absent;
      }
      if (i == 9) { //at last bit
        currentNode.count++;
      }
    }
  }

  private long findCountRec(BitSet bitFlag, int index, TrieNode currentNode) {
    if (currentNode == null) {
      return 0;
    } else if (index == 10) {
      return currentNode.count;
    }

    if (bitFlag.get(index)) {
      return findCountRec(bitFlag, index + 1, currentNode.present);
    } else {
      return findCountRec(bitFlag, index + 1, currentNode.present) +
          findCountRec(bitFlag, index + 1, currentNode.absent);
    }
  }

  public long findCount(BitSet bitFlag) {
    return findCountRec(bitFlag, 0, root);
  }

  class TrieNode {

    TrieNode present = null;
    TrieNode absent = null;
    long count = 0;
  }
}
