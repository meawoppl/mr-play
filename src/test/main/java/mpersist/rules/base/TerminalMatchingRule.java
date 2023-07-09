package mpersist.rules.base;

import mpersist.forms.DigitalBigInteger;

public class TerminalMatchingRule extends MatchingRule {
  @Override
  public boolean isTerminal() {
    return true;
  }

  public TerminalMatchingRule(String match) {
    super(match);
  }

  @Override
  public DigitalBigInteger applyImpl(DigitalBigInteger digitalBigInteger) throws TerminationCase {
    throw new TerminationCase();
  }
}
