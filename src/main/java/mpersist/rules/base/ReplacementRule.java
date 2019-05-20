package mpersist.rules.base;

import mpersist.forms.DigitalBigInteger;

public class ReplacementRule extends MatchingRule {

  @Override
  public boolean isTerminal() {
    return false;
  }

  public ReplacementRule(String from, String to) {
    super(from, to);
  }

  @Override
  protected DigitalBigInteger applyImpl(DigitalBigInteger digitalBigInteger) {
    return new DigitalBigInteger(applyTransform(digitalBigInteger.getDigitHistorgram()));
  }
}
