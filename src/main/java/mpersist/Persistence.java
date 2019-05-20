package mpersist;

import java.math.BigInteger;

public class Persistence {
  private Persistence() {}

  public static int compute(long value) {
    return compute(Long.toString(value));
  }

  public static int compute(String value) {
    if (value.length() == 1) {
      return 0;
    }

    int[] elements = PureFuncs.stringToIntElements(value);
    BigInteger newValue = PureFuncs.product(elements);

    return compute(newValue) + 1;
  }

  public static int compute(BigInteger value) {
    return compute(value.toString());
  }
}
