package DataStructure;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PriorityQueueTest {

  @Test
  void simple() {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    pq.add(4);
    pq.add(3);
    pq.add(2);
    pq.add(1);
    pq.add(5);
    pq.add(6);

    int prevVal = -Integer.MAX_VALUE;
    boolean ascending = true;
    while (pq.count() > 0) {
      int val = pq.pop();
      if (val < prevVal) {
        ascending = false;
      }

      prevVal = val;
    }

    assertTrue(ascending);
  }
}
