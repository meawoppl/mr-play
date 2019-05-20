package mpersist.forms;

import java.math.BigInteger;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class DigitFormTest {

  @Test
  public void testToBigInteger() {
    BigInteger original = new BigInteger("123");
    DigitForm df = new DigitForm(original);

    Assertions.assertThat(df.toBigInteger()).isEqualTo(original);
  }
}
