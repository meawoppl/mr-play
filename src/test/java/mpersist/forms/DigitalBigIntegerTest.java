package mpersist.forms;

import java.math.BigInteger;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class DigitalBigIntegerTest {

  @Test
  public void testConstructors() {
    Assertions.assertThat(new DigitalBigInteger(23))
        .isEqualTo(new DigitalBigInteger("23"))
        .isEqualTo(new DigitalBigInteger(new BigInteger("23")));
  }

  @Test
  public void testNOfDigit() {
    DigitalBigInteger dbi = new DigitalBigInteger("1123");
    Assertions.assertThat(dbi.nOfDigit(1)).isEqualTo(2);
    Assertions.assertThat(dbi.nOfDigit(2)).isEqualTo(1);
    Assertions.assertThat(dbi.nOfDigit(3)).isEqualTo(1);
  }

  @Test
  public void testGetDigitArray() {
    {
      DigitalBigInteger dbi = new DigitalBigInteger("1123");
      Assertions.assertThat(dbi.getDigitCount())
          .isEqualTo(new int[] {0, 2, 1, 1, 0, 0, 0, 0, 0, 0});
    }

    {
      DigitalBigInteger dbi = new DigitalBigInteger("9999");
      Assertions.assertThat(dbi.getDigitCount())
          .isEqualTo(new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 4});
    }
  }

  @Test
  public void testContainsZeros() {
    {
      DigitalBigInteger dbi = new DigitalBigInteger("1123");
      Assertions.assertThat(dbi.containsZeros()).isFalse();
    }

    {
      DigitalBigInteger dbi = new DigitalBigInteger("1103");
      Assertions.assertThat(dbi.containsZeros()).isTrue();
    }
  }
}
