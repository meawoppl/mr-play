package mpersist;

import java.math.BigInteger;
import java.util.Arrays;

public class PureFuncs {
  public static int[] toIntArray(BigInteger bi) {
    String string = bi.toString();
    int[] array = new int[string.length()];

    for (int i = 0; i < string.length(); i++) {
      array[i] = Integer.parseInt(string.substring(i, i + 1));
    }

    return array;
  }

  /**
   * Sort a string of digits.
   *
   * <p>Example "0123" == sortedDigitString("1302")
   */
  public static String sortedDigitString(String input) {
    char[] chars = input.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }

  /**
   * Transform a string into an array of integer elements. Example: new int[]{1, 2, 3} ==
   * stringToIntElements("123")
   *
   * @param string Input string
   * @return Array of integers.
   */
  public static int[] stringToIntElements(String string) {
    int[] values = new int[string.length()];

    for (int i1 = 0; i1 < values.length; i1++) {
      values[i1] = Integer.parseInt(string.substring(i1, i1 + 1));
    }

    return values;
  }

  /**
   * Make a String of length n filled with the character s
   *
   * @param n Final string length
   * @param s Character to fill the string with.
   * @return String of repeated characters
   */
  public static String nCharactersOf(int n, String s) {
    assert (n >= 0);
    assert (s.length() == 1);

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      sb.append(s);
    }

    return sb.toString();
  }

  /**
   * Return an int array which describes the number of times a particular digit occurs in the
   * stringFormed Number specified.
   *
   * @param number
   * @return
   */
  public static int[] digitHistogram(BigInteger number) {
    int[] hist = new int[10];
    for (int i : stringToIntElements(number.toString())) {
      hist[i] += 1;
    }
    return hist;
  }
}
