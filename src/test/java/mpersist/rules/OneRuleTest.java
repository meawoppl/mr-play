package mpersist.rules;

import java.math.BigInteger;
import mpersist.forms.DigitalBigInteger;
import mpersist.rules.base.Rule;
import mpersist.rules.base.TerminationCase;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class OneRuleTest {
  private static Rule rule = Rules.ONE_RULE;

  @Test
  public void testApplyImpl() {
    Assertions.assertThat(rule.applies(new DigitalBigInteger("111"))).isTrue();
    Assertions.assertThat(rule.applies(new DigitalBigInteger("321"))).isTrue();
    Assertions.assertThat(rule.applies(new DigitalBigInteger("131"))).isTrue();
    Assertions.assertThat(rule.applies(new DigitalBigInteger("123"))).isTrue();

    Assertions.assertThat(rule.applies(new DigitalBigInteger("1"))).isFalse();
  }

  @Test
  public void testApplication() throws TerminationCase {
    Assertions.assertThat(rule.apply(new DigitalBigInteger("111"))).isEqualTo(new BigInteger("11"));
    Assertions.assertThat(rule.apply(new DigitalBigInteger("321"))).isEqualTo(new BigInteger("23"));
    Assertions.assertThat(rule.apply(new DigitalBigInteger("111"))).isEqualTo(new BigInteger("11"));
    Assertions.assertThat(rule.apply(new DigitalBigInteger("131"))).isEqualTo(new BigInteger("13"));
  }
}
