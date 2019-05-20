package mpersist.rules;

import java.math.BigInteger;
import junit.framework.TestCase;
import mpersist.forms.DigitalBigInteger;
import mpersist.rules.base.Rule;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class OneRuleTest extends TestCase {
  private static Rule rule = Rules.ONE_RULE;

  @Test
  public void testApplyImpl() {
    assertTrue(rule.applies(new DigitalBigInteger("111")));
    assertTrue(rule.applies(new DigitalBigInteger("321")));
    assertTrue(rule.applies(new DigitalBigInteger("131")));
    assertTrue(rule.applies(new DigitalBigInteger("123")));

    assertFalse(rule.applies(new DigitalBigInteger("1")));
  }

  @Test
  public void testApplication() {
    Assertions.assertThat(rule.apply(new DigitalBigInteger("111"))).isEqualTo(new BigInteger("11"));
    Assertions.assertThat(rule.apply(new DigitalBigInteger("321"))).isEqualTo(new BigInteger("23"));
    Assertions.assertThat(rule.apply(new DigitalBigInteger("111"))).isEqualTo(new BigInteger("11"));
    Assertions.assertThat(rule.apply(new DigitalBigInteger("131"))).isEqualTo(new BigInteger("13"));
  }
}
