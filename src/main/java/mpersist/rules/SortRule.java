package mpersist.rules;

import mpersist.forms.DigitalBigInteger;
import mpersist.rules.base.Rule;

public class SortRule extends Rule {
  @Override
  public boolean isTerminal() {
    return false;
  }

  @Override
  protected DigitalBigInteger applyImpl(DigitalBigInteger digitalBigInteger) {
    int[] digits = digitalBigInteger.getDigitArray();
    return new DigitalBigInteger(digits);
  }

  @Override
  protected boolean appliesImpl(DigitalBigInteger digitalBigInteger) {
    if (digitalBigInteger.containsZeros()) return false;

    return !applyImpl(digitalBigInteger).equals(digitalBigInteger);
  }
}
