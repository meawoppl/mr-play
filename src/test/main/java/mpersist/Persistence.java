package mpersist;

import java.math.BigInteger;
import mpersist.forms.DigitalBigInteger;

public class Persistence {
  private Persistence() {}

  public static int compute(long value) {
    return compute(Long.toString(value));
  }

  public static int compute(String value) {
    return compute(new DigitalBigInteger(value));
  }

  public static int compute(BigInteger value) {
    return compute(value.toString());
  }

  public static int compute(DigitalBigInteger value) {
    if (value.nDigits() == 1) {
      return 0;
    }
    return compute(value.getDigitProduct()) + 1;
  }
}
