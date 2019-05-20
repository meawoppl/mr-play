package mpersist.forms;

import com.google.common.annotations.VisibleForTesting;
import java.math.BigInteger;
import java.util.Random;
import mpersist.PureFuncs;
import org.apache.commons.lang.StringUtils;

public class DigitalBigInteger extends BigInteger {
  public static DigitalBigInteger ONE = new DigitalBigInteger("1");

  public DigitalBigInteger(String number) {
    super(number);
  }

  public DigitalBigInteger(int[] nDigits) {
    this(digitCountToString(nDigits));
  }

  public DigitalBigInteger(int bitSize, Random random) {
    super(bitSize, random);
  }

  public DigitalBigInteger(BigInteger bi){
    super(bi.toString());
  }

  public static DigitalBigInteger fromValue(long value) {
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
    // TODO(meawoppl) optimize to precompute/store once
    assertValidDigit(digit);
    return StringUtils.countMatches(this.toString(), Integer.toString(digit));
  }

  public int nDigits() {
    // TODO(meawoppl) also faster with above todo addressed.
    assert (signum() >= 0);
    return toString().length();
  }

  public int[] getDigitArray(){
    return PureFuncs.stringToIntElements(toString());
  }

  public DigitalBigInteger getDigitProduct(){
    return PureFuncs.product(getDigitArray());
  }

  public int[] getDigitHistorgram() {
    int[] digits = new int[10];
    for (int i = 0; i < digits.length; i++) {
      digits[i] = nOfDigit(i);
    }
    return digits;
  }

  public boolean containsZeros() {
    return nOfDigit(0) != 0;
  }

  public DigitalBigInteger incrementDigit(int digit, int increment) {
    assertValidDigit(digit);

    int[] digits = getDigitHistorgram();
    digits[digit] += increment;

    return new DigitalBigInteger(digits);
  }

  public DigitalBigInteger setDigit(int digit, int value) {
    assertValidDigit(digit);
    assert (value >= 0);

    int[] digits = getDigitHistorgram();
    digits[digit] = value;

    return new DigitalBigInteger(digits);
  }

  public DigitalBigInteger multiply(BigInteger bigInteger) {
    return new DigitalBigInteger(bigInteger.multiply(this));
  }
}


