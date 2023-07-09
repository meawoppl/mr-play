package mpersist.rules.base;

import mpersist.forms.DigitalBigInteger;

public abstract class Rule {
  public class CanNotBeAppliedException extends RuntimeException {}

  public final boolean applies(DigitalBigInteger digitalBigInteger) {
    return appliesImpl(digitalBigInteger);
  }

  public final DigitalBigInteger apply(DigitalBigInteger digitalBigInteger) throws TerminationCase {
    assert (applies(digitalBigInteger));
    return applyImpl(digitalBigInteger);
  }

  public abstract boolean appliesImpl(DigitalBigInteger digitalBigInteger);

  public abstract DigitalBigInteger applyImpl(DigitalBigInteger digitalBigInteger)
      throws TerminationCase;

  public abstract boolean isTerminal();

  public String explainApplication(DigitalBigInteger digitalBigInteger) {
    String result;
    try {
      result = apply(digitalBigInteger).toString();
    } catch (TerminationCase t) {
      result = "Termination";
    }

    return String.format(
        "Transformation %s transforms %s -> %s.",
        getClass().getName(), digitalBigInteger.toString(), result);
  }
}
