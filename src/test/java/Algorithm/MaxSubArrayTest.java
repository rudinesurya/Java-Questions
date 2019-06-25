package Algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import org.junit.jupiter.api.Test;

class MaxSubArrayTest {

  @Test
  void simple() {
    int[] arr = {1, 2, 3};
    HashMap<String, Integer> result = MaxSubArray.getMaxSubArray(arr);
    assertEquals(6, result.get("sum").intValue());
  }

  @Test
  void withNegative() {
    int[] arr = {-1, 2, 3};
    HashMap<String, Integer> result = MaxSubArray.getMaxSubArray(arr);
    assertEquals(5, result.get("sum").intValue());
  }

  @Test
  void allNegative() {
    int[] arr = {-1, -2, -3};
    HashMap<String, Integer> result = MaxSubArray.getMaxSubArray(arr);
    assertEquals(-1, result.get("sum").intValue());
  }

  @Test
  void expectsZero() {
    int[] arr = {-1, -2, -3, 0};
    HashMap<String, Integer> result = MaxSubArray.getMaxSubArray(arr);
    assertEquals(0, result.get("sum").intValue());
  }

  @Test
  void unsorted() {
    int[] arr = {1, -2, 3, 1};
    HashMap<String, Integer> result = MaxSubArray.getMaxSubArray(arr);
    assertEquals(4, result.get("sum").intValue());
  }

  @Test
  void unsorted2() {
    int[] arr = {1, -2, 3, 1, -10, 13, -2};
    HashMap<String, Integer> result = MaxSubArray.getMaxSubArray(arr);
    assertEquals(13, result.get("sum").intValue());
  }
}
