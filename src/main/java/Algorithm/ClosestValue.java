package Algorithm;

public class ClosestValue {

  //return index of array of value which is less than or equal to num
  //-1 otherwise
  static int binarySearch(int[] arr, int num) {
    return binarySearch(arr, 0, arr.length - 1, num);
  }

  static int binarySearch(int[] arr, int l, int r, int num) {
    if (l <= r) {
      int mid = l + (r - l) / 2;
      if (arr[mid] == num) {
        return mid;
      } else if (num < arr[mid]) {
        return binarySearch(arr, l, mid - 1, num);
      } else {
        return binarySearch(arr, mid + 1, r, num);
      }
    }

    int index = r;
    while (index >= 0) {
      if (arr[index] <= num) {
        return index;
      }
      --index;
    }
    return -1;
  }
}
