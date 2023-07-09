package mpersist.rules;

import mpersist.forms.DigitalBigInteger;
import mpersist.rules.base.TerminalRule;
import mpersist.rules.base.TerminationCase;

public class SingleDigitRule extends TerminalRule {
  @Override
  public boolean appliesImpl(DigitalBigInteger digitalBigInteger) {
    return digitalBigInteger.nDigits() == 1;
  }

  @Override
  public DigitalBigInteger applyImpl(DigitalBigInteger digitalBigInteger) throws TerminationCase {
    throw new TerminationCase();
  }
}
