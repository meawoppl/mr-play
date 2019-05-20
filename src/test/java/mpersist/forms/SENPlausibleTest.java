package mpersist.forms;

import java.math.BigInteger;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class SENPlausibleTest {
  @Test
  public void testPlausibleInit() {
    new SENPlausible(1, 2, 3);
  }

  @Test
  public void testPlausibleAsBig() {
    SENPlausible p = new SENPlausible(1, 2, 3);
    Assertions.assertThat(p.asBigInteger()).isEqualTo(new BigInteger("788999"));
  }

  @Test
  public void testPrefix() {
    SENPlausible p = new SENPlausible("6", 1, 1, 1);
    Assertions.assertThat(p.asBigInteger()).isEqualTo(new BigInteger("6789"));
  }

  @Test
  public void testNDigits() {
    SENPlausible p = new SENPlausible("6", 1, 1, 1);
    Assertions.assertThat(p.nDigits()).isEqualTo(4);
  }
}
