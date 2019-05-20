package mpersist.rules;

import mpersist.forms.DigitalBigInteger;
import mpersist.rules.base.Rule;

public class OneRule extends Rule {
  @Override
  public boolean isTerminal() {
    return false;
  }

  @Override
  protected DigitalBigInteger applyImpl(DigitalBigInteger digitalBigInteger) {
    int[] digits = digitalBigInteger.getDigitHistorgram();
    digits[1] -= 1;
    return new DigitalBigInteger(digits);
  }

  @Override
  protected boolean appliesImpl(DigitalBigInteger digitalBigInteger) {
    if (digitalBigInteger.containsZeros()) return false;

    return (digitalBigInteger.nOfDigit(1)) != 0 && (digitalBigInteger.nDigits() > 1);
  }
}
