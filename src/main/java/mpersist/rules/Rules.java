package mpersist.rules;

import com.google.common.collect.Lists;
import java.math.BigInteger;
import java.util.List;
import mpersist.forms.DigitalBigInteger;
import mpersist.rules.base.*;

public class Rules {
  private Rules() {}

  public static Rule ANY_ZEROS = new TerminalMatchingRule("0");
  public static Rule SORT_RULE = new SortRule();
  public static Rule ONE_RULE = new OneRule();

  public static Rule TWO_TWOS = new ReplacementRule("22", "4");
  public static Rule TWO_THREE = new ReplacementRule("23", "6");
  public static Rule TWO_FOUR = new ReplacementRule("24", "8");

  public static Rule THREE_THREE = new ReplacementRule("33", "9");
  public static Rule THREE_FOUR = new ReplacementRule("34", "26");
  public static Rule FOUR_FOUR = new ReplacementRule("44", "28");
  public static Rule FOUR_SIX = new ReplacementRule("46", "38");

  // These result in a 0 as the last digit in the next round
  public static Rule TWO_FIVE = new TerminalMatchingRule("25");
  public static Rule FOUR_FIVE = new TerminalMatchingRule("45");
  public static Rule SIX_FIVE = new TerminalMatchingRule("65");
  public static Rule EIGHT_FIVE = new TerminalMatchingRule("85");
  public static Rule DOUBLE_SIX = new ReplacementRule("66", "49");
  public static Rule SINGLE_DIGIT = new SingleDigitRule();

  public static Rule INTERESTING = new ReplacementRule("368", "289");

  public static List<Rule> RULES =
      Lists.newArrayList(
          ANY_ZEROS,
          SINGLE_DIGIT,
          TWO_FIVE,
          FOUR_FIVE,
          SIX_FIVE,
          EIGHT_FIVE,
          SORT_RULE,
          DOUBLE_SIX,
          ONE_RULE,
          TWO_TWOS,
          TWO_THREE,
          TWO_FOUR,
          THREE_THREE,
          THREE_FOUR,
          FOUR_FOUR,
          FOUR_SIX,
          INTERESTING);

  public static boolean terminates(DigitalBigInteger dbi) {
    try {
      applyRepeated(dbi);
    } catch (TerminationCase t) {
      return false;
    }

    return true;
  }

  public static DigitalBigInteger applyFirst(DigitalBigInteger dbi) throws TerminationCase {
    for (Rule rule : RULES) {
      if (rule.applies(dbi)) {
        return rule.apply(dbi);
      }
    }

    return dbi;
  }

  public static DigitalBigInteger applyRepeated(DigitalBigInteger dbi) throws TerminationCase {
    DigitalBigInteger transformed = applyFirst(dbi);
    if (transformed.equals(dbi)) {
      return dbi;
    }
    return applyRepeated(transformed);
  }

  public static DigitalBigInteger toMinimalForm(BigInteger dbi) {
    try {
      return applyRepeated(new DigitalBigInteger(dbi));
    } catch (TerminationCase t) {
      throw new AssertionError(
          String.format("toMinimalForm(%s) called on terminating case.", dbi.toString()));
    }
  }
}
