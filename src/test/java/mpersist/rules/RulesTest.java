package mpersist.rules;

import java.util.Random;
import mpersist.Persistence;
import mpersist.forms.DigitalBigInteger;
import mpersist.rules.base.Rule;
import mpersist.rules.base.TerminationCase;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class RulesTest {
  private int RANDOM_TEST_COUNT = 50;
  private int BIT_SIZE = 1000;
  private int RANDOM_SEED = 3;

  @Test
  public void testRuleApplicationPreservesPersistence() {
    for (int i = 1; i < 100; i++) {
      DigitalBigInteger bi = new DigitalBigInteger(i);

      int original = Persistence.compute(bi);

      for (Rule rule : Rules.RULES) {
        if (!rule.applies(bi)) {
          continue;
        }

        DigitalBigInteger simplified;
        try {
          simplified = rule.apply(bi);
        } catch (TerminationCase t) {
          Assertions.assertThat(original).isLessThanOrEqualTo(2);
          continue;
        }
        // We only want rules that yield smaller numbers.
        Assertions.assertThat(simplified.intValue()).isLessThan(bi.intValue());

        Assertions.assertThat(Persistence.compute(simplified))
            .withFailMessage(rule.explainApplication(bi))
            .isLessThanOrEqualTo(original);
        rule.explainApplication(bi);
      }
    }
  }

  @Test
  public void testFuzzRules() {
    Random random = new Random(RANDOM_SEED);

    for (int i = 0; i < RANDOM_TEST_COUNT; i++) {
      DigitalBigInteger bi = new DigitalBigInteger(BIT_SIZE, random);
      for (Rule rule : Rules.RULES) {
        if (rule.applies(bi)) {
          try {
            rule.apply(bi);
          } catch (TerminationCase t) {
            Assertions.assertThat(rule.isTerminal());
          }
        }
      }
    }
  }

  @Test
  public void testApplyFirst() throws TerminationCase {
    Assertions.assertThat(Rules.applyFirst(new DigitalBigInteger("211")))
        .isEqualTo(new DigitalBigInteger("112"));
    Assertions.assertThat(Rules.applyFirst(new DigitalBigInteger("111")))
        .isEqualTo(new DigitalBigInteger("11"));
    Assertions.assertThat(Rules.applyFirst(new DigitalBigInteger("22")))
        .isEqualTo(new DigitalBigInteger("4"));
  }

  @Test
  public void testApplyRepeated() throws TerminationCase {
    Assertions.assertThatExceptionOfType(TerminationCase.class)
        .isThrownBy(() -> Rules.applyRepeated(new DigitalBigInteger("1")));

    Assertions.assertThatExceptionOfType(TerminationCase.class)
        .isThrownBy(() -> Rules.applyRepeated(new DigitalBigInteger("11111")));
  }
}
