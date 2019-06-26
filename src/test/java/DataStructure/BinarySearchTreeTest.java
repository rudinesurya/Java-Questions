package DataStructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {

  @Test
  void simple() {
    BinarySearchTree tree = new BinarySearchTree();
    tree.insert(3);
    tree.insert(4);
    tree.insert(5);
    tree.insert(1);
    tree.insert(2);

    try {
      int min = tree.getMin();
      int max = tree.getMax();

      assertEquals(1, min);
      assertEquals(5, max);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  void withNegatives() {
    BinarySearchTree tree = new BinarySearchTree();
    tree.insert(-3);
    tree.insert(4);
    tree.insert(5);
    tree.insert(-1);
    tree.insert(2);

    try {
      int min = tree.getMin();
      int max = tree.getMax();

      assertEquals(-3, min);
      assertEquals(5, max);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  void allNegatives() {
    BinarySearchTree tree = new BinarySearchTree();
    tree.insert(-3);
    tree.insert(-4);
    tree.insert(-5);
    tree.insert(-1);
    tree.insert(-2);

    try {
      int min = tree.getMin();
      int max = tree.getMax();

      assertEquals(-5, min);
      assertEquals(-1, max);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  void singleNode() {
    BinarySearchTree tree = new BinarySearchTree();
    tree.insert(3);

    try {
      int min = tree.getMin();
      int max = tree.getMax();

      assertEquals(3, min);
      assertEquals(3, max);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  void emptyTree() {
    BinarySearchTree tree = new BinarySearchTree();
    assertThrows(Exception.class, tree::getMin);
    assertThrows(Exception.class, tree::getMax);
  }

  @Test
  void withRemoval() {
    BinarySearchTree tree = new BinarySearchTree();
    tree.insert(3);
    tree.insert(4);
    tree.insert(5);
    tree.insert(1);
    tree.insert(2);

    tree.remove(1);
    tree.remove(5);

    try {
      int min = tree.getMin();
      int max = tree.getMax();

      assertEquals(2, min);
      assertEquals(4, max);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  void withRemoval2() {
    BinarySearchTree tree = new BinarySearchTree();
    tree.insert(3);
    tree.insert(4);
    tree.insert(5);
    tree.insert(1);
    tree.insert(2);

    tree.remove(1);
    tree.remove(5);

    tree.insert(-2);
    tree.insert(8);

    try {
      int min = tree.getMin();
      int max = tree.getMax();

      assertEquals(-2, min);
      assertEquals(8, max);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
