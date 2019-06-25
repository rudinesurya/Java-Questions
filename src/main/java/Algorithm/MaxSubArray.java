package Algorithm;

import java.util.HashMap;

public class MaxSubArray {

  public static HashMap<String, Integer> getMaxSubArray(int[] A) {
    HashMap<String, Integer> result = new HashMap<>();
    int len = A.length;
    int max_start = 0, max_end = 0;
    int start = 0;
    int max = A[0];
    int prev = A[0]; // val of local max sub array, to use for next iteration
    for (int i = 1; i < len; ++i) {
      int val = A[i];
      int newSubArrVal = val + prev;
      // if val is greater than the sum of prev and val, then simply make it the local max sub array
      if (newSubArrVal < val) {
        newSubArrVal = val;
        start = i;
      }

      // here, the global max gets updated
      if (newSubArrVal > max) {
        max = newSubArrVal;
        max_start = start;
        max_end = i;
      }

      prev = newSubArrVal;
    }

    result.put("start", max_start);
    result.put("end", max_end);
    result.put("sum", max);
    return result;
  }
}
