package Algorithm;

public class BinaryGap {

  private static String getBinary(int n) {
    return Integer.toBinaryString(n);
  }

  public static int find(int n) {
    String bin = getBinary(n);

    int maxLen = 0;
    int onePos = -1;
    int count = 0;
    for (int i = 0; i < bin.length(); ++i) {
      char c = bin.charAt(i);
      if (c == '1') {
        if (onePos != -1) {
          maxLen = Math.max(maxLen, count);
          count = 0;
        }
        onePos = i;
      } else {
        if (onePos != -1) {
          ++count;
        }
      }
    }
    return maxLen;
  }
}
