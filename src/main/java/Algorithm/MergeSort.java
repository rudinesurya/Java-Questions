package Algorithm;

public class MergeSort<T extends Comparable> {

  private T[] data;
  private T[] tempArray;

  public void sort(T[] arr) {
    data = arr;
    tempArray = (T[]) new Comparable[arr.length];
    mergeSort(0, arr.length - 1);
  }

  private void mergeSort(int start, int end) {
    if (start < end) {
      int midP = start + (end - start) / 2;

      mergeSort(start, midP);
      mergeSort(midP + 1, end);
      merge(start, midP, end);
    }
  }

  private void merge(int start, int midP, int end) {
    //copy to tempArray
    for (int i = start; i <= end; ++i) {
      tempArray[i] = data[i];
    }

    int f = start;
    int i = start;
    int j = midP + 1;

    while (i <= midP && j <= end) {
      if (tempArray[i].compareTo(tempArray[j]) < 0) {
        data[f] = tempArray[i];
        ++i;
      } else {
        data[f] = tempArray[j];
        ++j;
      }
      ++f;
    }

    while (i <= midP) {
      data[f] = tempArray[i];
      ++f;
      ++i;
    }

    while (j <= end) {
      data[f] = tempArray[j];
      ++f;
      ++j;
    }
  }
}
