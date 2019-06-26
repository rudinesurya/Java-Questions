package Algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BinaryGapTest {

  @Test
  void simple() {
    int n = 9; // 1001
    int max = BinaryGap.find(n);

    assertEquals(2, max);
  }

  @Test
  void simple2() {
    int n = 529; // 1000010001
    int max = BinaryGap.find(n);

    assertEquals(4, max);
  }

  @Test
  void simple3() {
    int n = 20; // 10100
    int max = BinaryGap.find(n);

    assertEquals(1, max);
  }

  @Test
  void simple4() {
    int n = 15; // 1111
    int max = BinaryGap.find(n);

    assertEquals(0, max);
  }

  @Test
  void simple5() {
    int n = 32; // 100000
    int max = BinaryGap.find(n);

    assertEquals(0, max);
  }
}
