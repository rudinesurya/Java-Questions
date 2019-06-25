package Algorithm;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Random;
import org.junit.jupiter.api.Test;

class MergeSortTest {

  private void shuffleArray(Integer[] array) {
    int index, temp;
    Random random = new Random();
    for (int i = array.length - 1; i > 0; i--) {
      index = random.nextInt(i + 1);
      temp = array[index];
      array[index] = array[i];
      array[i] = temp;
    }
  }

  @Test
  void simple() {
    Integer[] sorted = {1, 2, 3, 4, 5, 6, 7};
    Integer[] arr = sorted.clone();
    shuffleArray(arr);

    MergeSort<Integer> sorter = new MergeSort<>();
    sorter.sort(arr);

    assertArrayEquals(sorted, arr);
  }

  @Test
  void withNegatives() {
    Integer[] sorted = {-3, -2, 0, 1, 2, 3};
    Integer[] arr = sorted.clone();
    shuffleArray(arr);

    MergeSort<Integer> sorter = new MergeSort<>();
    sorter.sort(arr);

    assertArrayEquals(sorted, arr);
  }
}
