package mpersist.rules.base;

import mpersist.PureFuncs;
import mpersist.forms.DigitalBigInteger;

public abstract class MatchingRule extends Rule {
  private final int[] transformation;

  private int[] getTransformation() {
    return transformation;
  }

  private MatchingRule(int[] transformation) {
    this.transformation = transformation;
    assert (transformation.length == 10);
  }

  public MatchingRule(String from) {
    this(from, "");
  }

  public MatchingRule(String from, String to) {
    this(ruleFromStrings(from, to));
  }

  private static int[] ruleFromStrings(String from, String to) {
    int[] rule = new int[10];

    for (int i : PureFuncs.stringToIntElements(from)) {
      rule[i] -= 1;
    }

    for (int i : PureFuncs.stringToIntElements(to)) {
      rule[i] += 1;
    }

    return rule;
  }

  public int[] applyTransform(int[] input) {
    int[] ret = new int[10];
    int[] xform = getTransformation();
    for (int i = 0; i < ret.length; i++) {
      ret[i] = input[i] + xform[i];
    }

    return ret;
  }

  @Override
  public boolean appliesImpl(DigitalBigInteger digitalBigInteger) {
    int[] transformed = applyTransform(digitalBigInteger.getDigitCount());
    for (int t : transformed) {
      if (t < 0) {
        return false;
      }
    }
    return true;
  }
}
