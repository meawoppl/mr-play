package mpersist.rules;

import mpersist.forms.DigitalBigInteger;
import mpersist.rules.base.Rule;

public class ZeroRule extends Rule {
  @Override
  public boolean isTerminal() {
    return false;
  }

  @Override
  public DigitalBigInteger applyImpl(DigitalBigInteger digitalBigInteger) {
    return new DigitalBigInteger("0");
  }

  @Override
  public boolean appliesImpl(DigitalBigInteger digitalBigInteger) {
    return digitalBigInteger.nOfDigit(0) != 0;
  }
}
