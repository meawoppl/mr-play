package mpersist.rules.base;

import mpersist.forms.DigitalBigInteger;

public class TerminationRule extends MatchingRule {
  public TerminationRule(String match) {
    super(match, "");
  }

  @Override
  public boolean isTerminal() {
    return true;
  }

  @Override
  protected DigitalBigInteger applyImpl(DigitalBigInteger digitalBigInteger) {
    throw new RuntimeException("Can not apply termination rule");
  }
}
