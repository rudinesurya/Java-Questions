package Algorithm;

import java.util.HashMap;

public class MaxSubArray {

  public static HashMap<String, Integer> getMaxSubArray(int[] A) {
    HashMap<String, Integer> result = new HashMap();
    int len = A.length;
    int max_start = 0, max_end = 0;
    int start = 0;
    int max = A[0];
    int prev = max;
    for (int i = 1; i < len; ++i) {
      int val = A[i];
      int newSubArrVal = val + prev;
      if (newSubArrVal < val) {
        newSubArrVal = val;
        start = i;
      }

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
