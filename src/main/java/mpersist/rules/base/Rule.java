package mpersist.rules.base;

import mpersist.forms.DigitalBigInteger;

public abstract class Rule {
  public final boolean applies(DigitalBigInteger digitalBigInteger) {
    return appliesImpl(digitalBigInteger);
  }

  public final DigitalBigInteger apply(DigitalBigInteger digitalBigInteger) {
    assert (applies(digitalBigInteger));
    return applyImpl(digitalBigInteger);
  }

  protected abstract boolean appliesImpl(DigitalBigInteger digitalBigInteger);

  protected abstract DigitalBigInteger applyImpl(DigitalBigInteger digitalBigInteger);

  public abstract boolean isTerminal();

  public String explainApplication(DigitalBigInteger digitalBigInteger) {
    return String.format(
        "Transformation %s transforms %s -> %s.",
        getClass().getName(), digitalBigInteger.toString(), apply(digitalBigInteger).toString());
  }
}
