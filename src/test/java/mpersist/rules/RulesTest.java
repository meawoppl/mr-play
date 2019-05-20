package mpersist.rules;

import java.util.Random;
import junit.framework.TestCase;
import mpersist.Persistence;
import mpersist.forms.DigitalBigInteger;
import mpersist.rules.base.Rule;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class RulesTest extends TestCase {
  private int RANDOM_TEST_COUNT = 50;
  private int BIT_SIZE = 1000;
  private int RANDOM_SEED = 3;

  @Test
  public void testRuleApplicationPreservesPersistence() {
    for (int i = 1; i < 100; i++) {
      DigitalBigInteger bi = DigitalBigInteger.fromValue(i);

      int original = Persistence.compute(bi);

      for (Rule rule : Rules.RULES) {
        if (rule.applies(bi)) {
          if (rule.isTerminal()) {
            Assertions.assertThat(original).isLessThanOrEqualTo(2);
          } else {
            DigitalBigInteger simplified = rule.apply(bi);
            // We only want rules that yield smaller numbers.
            Assertions.assertThat(simplified.intValue()).isLessThan(bi.intValue());

            Assertions.assertThat(Persistence.compute(simplified))
                .withFailMessage(rule.explainApplication(bi))
                .isLessThanOrEqualTo(original);
            rule.explainApplication(bi);
          }
        }
      }
    }
  }

  @Test
  public void testFuzzRules() {
    Random random = new Random(RANDOM_SEED);

    for (int i = 0; i < RANDOM_TEST_COUNT; i++) {
      DigitalBigInteger bi = new DigitalBigInteger(BIT_SIZE, random);
      for (Rule rule : Rules.RULES) {
        if (rule.applies(bi) && !rule.isTerminal()) {
          rule.apply(bi);
        }
      }
    }
  }
}
