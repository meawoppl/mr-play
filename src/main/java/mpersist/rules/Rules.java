package mpersist.rules;

import com.google.common.collect.Lists;
import java.util.List;
import mpersist.rules.base.ReplacementRule;
import mpersist.rules.base.Rule;
import mpersist.rules.base.TerminationRule;

public class Rules {
  private Rules() {}

  public static Rule ANY_ZEROS = new TerminationRule("0");
  public static Rule SORT_RULE = new SortRule();
  public static Rule ONE_RULE = new OneRule();

  public static Rule TWO_TWOS = new ReplacementRule("22", "4");
  public static Rule TWO_THREE = new ReplacementRule("23", "6");
  public static Rule TWO_FOUR = new ReplacementRule("24", "8");
  public static Rule TWO_FIVE = new TerminationRule("25");

  public static Rule THREE_THREE = new ReplacementRule("33", "9");

  //  public static Rule TWO_SIX = new ReplacementRule("26", "")
  //  public static Rule TWO_TWOS = new ReplacementRule("22", "4");
  //  public static Rule TWO_TWOS = new ReplacementRule("22", "4");

  public static List<Rule> RULES =
      Lists.newArrayList(
          ANY_ZEROS, SORT_RULE, ONE_RULE, TWO_TWOS, TWO_THREE, TWO_FOUR, TWO_FIVE, THREE_THREE);
}
