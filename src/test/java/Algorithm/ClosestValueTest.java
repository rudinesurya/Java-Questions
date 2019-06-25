package Algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ClosestValueTest {

  @Test
  void returnExact() {
    int[] arr = {0, 1, 2, 3, 4, 5};
    int num = 3;
    int index = ClosestValue.binarySearch(arr, num);

    assertEquals(3, index);
  }

  @Test
  void returnClosest() {
    int[] arr = {0, 1, 2, 3, 4, 5};
    int num = 6;
    int index = ClosestValue.binarySearch(arr, num);

    assertEquals(5, index);
  }

  @Test
  void valueDoesntExist() {
    int[] arr = {3, 4, 5};
    int num = 2;
    int index = ClosestValue.binarySearch(arr, num);

    assertEquals(-1, index);
  }
}
