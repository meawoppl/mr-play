package mpersist.forms;

import java.math.BigInteger;
import java.util.Arrays;
import mpersist.PureFuncs;

public class DigitForm {
  int[] digitCount = new int[10];

  public DigitForm(int[] digitCount) {
    assert (digitCount.length == 10);
    for (int digit : digitCount) {
      assert (digit >= 0);
    }

    this.digitCount = Arrays.copyOf(digitCount, 10);
  }

  public DigitForm(BigInteger bi) {
    int[] digits = PureFuncs.toIntArray(bi);

    for (int digit : digits) {
      digitCount[digit] += 1;
    }
  }

  public BigInteger toBigInteger() {
    StringBuilder sb = new StringBuilder();

    for (int i = 1; i < 10; i++) {
      int count = digitCount[i];
      sb.append(PureFuncs.nCharactersOf(count, Integer.toString(i)));
    }

    return new BigInteger(sb.toString());
  }

  public int nOfDigit(int digit) {
    return digitCount[digit];
  }

  public DigitForm setNTo(int digit, int value) {
    int[] digits = digitArray();
    digits[digit] = value;
    return new DigitForm(digits);
  }

  public int[] digitArray() {
    return Arrays.copyOf(digitCount, 10);
  }
}
