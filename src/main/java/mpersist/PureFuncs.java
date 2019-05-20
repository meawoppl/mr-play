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

  public static String sortedDigitString(String input) {
    char[] chars = input.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }

  public static BigInteger sortedBigInteger(BigInteger bi) {
    return new BigInteger(sortedDigitString(bi.toString()));
  }

  public static int[] stringToIntElements(String val) {
    int[] values = new int[val.length()];

    for (int i1 = 0; i1 < values.length; i1++) {
      values[i1] = Integer.parseInt(val.substring(i1, i1 + 1));
    }

    return values;
  }

  public static String nCharactersOf(int n, String s) {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      sb.append(s);
    }

    return sb.toString();
  }

  public static BigInteger product(int[] ints) {
    assert (ints.length > 0);

    BigInteger newValue = BigInteger.ONE;
    for (int i : ints) {
      newValue = newValue.multiply(BigInteger.valueOf(i));
    }
    return newValue;
  }
}
