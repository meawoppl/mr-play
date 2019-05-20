package mpersist.forms;

import static org.junit.Assert.*;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class DigitalBigIntegerTest {

  @Test
  public void assertValidDigit() {}

  @Test
  public void assertDigitsValid() {}

  @Test
  public void nOfDigit() {
    DigitalBigInteger dbi = new DigitalBigInteger("1123");
    Assertions.assertThat(dbi.nOfDigit(1)).isEqualTo(2);
    Assertions.assertThat(dbi.nOfDigit(2)).isEqualTo(1);
    Assertions.assertThat(dbi.nOfDigit(3)).isEqualTo(1);
  }

  @Test
  public void getDigitArray() {}

  @Test
  public void containsZeros() {}

  @Test
  public void incrementDigit() {}
}
