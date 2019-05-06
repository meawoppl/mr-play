import java.math.BigInteger;
import java.util.Arrays;

public class PureFuncs {
  public static String sortedDigitString(String input) {
    char[] chars = input.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }

  public static int computeMultiplicativeResistance(long value) {
    return computeMultiplicativeResistance(Long.toString(value));
  }

  public static int computeMultiplicativeResistance(String value) {
    if (value.length() == 1) {
      return 0;
    }

    int[] elements = stringToIntElements(value);
    BigInteger newValue = product(elements);

    return computeMultiplicativeResistance(newValue) + 1;
  }

  public static int computeMultiplicativeResistance(BigInteger value) {
    return computeMultiplicativeResistance(value.toString());
  }

  public static int[] stringToIntElements(String val) {
    int[] values = new int[val.length()];

    for (int i1 = 0; i1 < values.length; i1++) {
      values[i1] = Integer.parseInt(val.substring(i1, i1 + 1));
    }

    return values;
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
