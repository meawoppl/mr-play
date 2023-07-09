package mpersist.rules;

import mpersist.forms.DigitalBigInteger;
import mpersist.rules.base.Rule;

public class SortRule extends Rule {
  @Override
  public boolean isTerminal() {
    return false;
  }

  @Override
  public DigitalBigInteger applyImpl(DigitalBigInteger digitalBigInteger) {
    int[] digits = digitalBigInteger.getDigitCount();
    return new DigitalBigInteger(digits);
  }

  @Override
  public boolean appliesImpl(DigitalBigInteger digitalBigInteger) {
    if (digitalBigInteger.containsZeros()) return false;

    return !applyImpl(digitalBigInteger).equals(digitalBigInteger);
  }
}
