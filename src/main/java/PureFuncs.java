import java.math.BigInteger;
import java.util.Arrays;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class PureFuncs {
  public static char[] toCharArray(BigInteger bi) {
    return bi.toString().toCharArray();
  }

  public static String sortedDigitString(String input) {
    char[] chars = input.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }

  public static BigInteger sortedBigInteger(BigInteger bi) {
    return new BigInteger(sortedDigitString(bi.toString()));
  }

  public static class NoMinimalFormException extends Throwable {
    private BigInteger bi;

    public NoMinimalFormException(BigInteger bi) {
      this.bi = bi;
    }

    @Override
    public String toString() {
      return String.format("There is a zero in %s", bi.toString());
    }
  }

  public static BigInteger toMinimalForm(BigInteger bi) throws NoMinimalFormException {
    for (char c : toCharArray(bi)) {
      if (c == 0) {
        throw new NoMinimalFormException(bi);
      }
    }

    // Chop off leading 1's
    String sorted = sortedDigitString(bi.toString());
    while (sorted.startsWith("1")) {
      sorted = sorted.substring(1);
    }

    // Reduce a pair of leading 2's to a 4
    if (sorted.startsWith("22")) {
      sorted = "4" + sorted.substring(2);
      return toMinimalForm(new BigInteger(sorted));
    }

    // TODO INCOMPLETE
    throw new NotImplementedException();
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
