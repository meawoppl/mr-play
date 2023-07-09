package mpersist.forms;

import com.google.common.annotations.VisibleForTesting;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;
import mpersist.PureFuncs;

public class DigitalBigInteger extends BigInteger {
  private final int[] digitCount;

  public static DigitalBigInteger ONE = new DigitalBigInteger("1");

  public DigitalBigInteger(long value) {
    this(BigInteger.valueOf(value));
  }

  public DigitalBigInteger(String number) {
    super(number);
    digitCount = PureFuncs.digitHistogram(this);
  }

  public DigitalBigInteger(int[] nDigits) {
    this(digitCountToString(nDigits));
  }

  public DigitalBigInteger(int bitSize, Random random) {
    super(bitSize, random);
    digitCount = PureFuncs.digitHistogram(this);
  }

  public DigitalBigInteger(BigInteger bi) {
    super(bi.toString());
    digitCount = PureFuncs.digitHistogram(this);
  }

  public static DigitalBigInteger fromLong(long value) {
    return new DigitalBigInteger(BigInteger.valueOf(value).toString());
  }

  @VisibleForTesting
  protected static void assertValidDigit(int digit) {
    assert (digit >= 0 && digit < 10);
  }

  @VisibleForTesting
  protected static void assertDigitsValid(int[] digits) {
    assert (digits.length == 10);
    for (int i = 0; i < digits.length; i++) {
      assert (digits[i] >= 0);
    }
  }

  private static String digitCountToString(int[] digitCount) {
    assertDigitsValid(digitCount);
    StringBuilder sb = new StringBuilder();

    for (int i = 1; i < 10; i++) {
      int count = digitCount[i];
      sb.append(PureFuncs.nCharactersOf(count, Integer.toString(i)));
    }

    if (sb.length() == 0) {
      sb.append("0");
    }

    return sb.toString();
  }

  public int nOfDigit(int digit) {
    assertValidDigit(digit);
    return digitCount[digit];
  }

  public int nDigits() {
    assert (signum() >= 0);
    int total = 0;
    for (int count : digitCount) {
      total += count;
    }
    return total;
  }

  public int[] getDigitArray() {
    return PureFuncs.stringToIntElements(toString());
  }

  public DigitalBigInteger getDigitProduct() {
    return product(getDigitArray());
  }

  /**
   * Compute the product of a array of integers in BigInteger space.
   *
   * @param ints Array of integers.
   * @return BigInteger computed product
   */
  private static DigitalBigInteger product(int[] ints) {
    assert (ints.length > 0);

    DigitalBigInteger newValue = DigitalBigInteger.ONE;
    for (int i : ints) {
      newValue = newValue.multiply(BigInteger.valueOf(i));
    }
    return newValue;
  }

  public int[] getDigitCount() {
    return Arrays.copyOf(digitCount, 10);
  }

  public boolean containsZeros() {
    return nOfDigit(0) != 0;
  }

  public DigitalBigInteger multiply(BigInteger bigInteger) {
    return new DigitalBigInteger(bigInteger.multiply(this));
  }

  public DigitalBigInteger trimSEN() {
    int[] count = getDigitCount();
    count[7] = 0;
    count[8] = 0;
    count[9] = 0;
    return new DigitalBigInteger(count);
  }
}
