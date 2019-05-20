package mpersist.generators;

import java.util.Set;
import mpersist.forms.DigitalBigInteger;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class RangeGeneratorTest extends GeneratorTestHelpers {
  @Test
  public void testRangeGeneratorConstructor() {
    RangeGenerator rg = new RangeGenerator(1, 5);
    Set<DigitalBigInteger> set = exhaustGeneratorAssertSize(rg, 4);

    Assertions.assertThat(set)
        .containsExactlyInAnyOrder(
            new DigitalBigInteger("1"),
            new DigitalBigInteger("2"),
            new DigitalBigInteger("3"),
            new DigitalBigInteger("4"));
  }

  @Test
  public void testDigitGeneratorSingleDigit() {
    RangeGenerator dense = RangeGenerator.forNDigits(1);
    Set<DigitalBigInteger> sbi = exhaustGeneratorAssertSize(dense, 9);

    for (DigitalBigInteger bi : sbi) {
      Assertions.assertThat(bi.toString().length()).isEqualTo(1);
    }
  }

  @Test
  public void testDigitGeneratorTripleDigit() {
    RangeGenerator dense = RangeGenerator.forNDigits(3);
    Set<DigitalBigInteger> sbi = exhaustGeneratorAssertSize(dense, 900);

    for (DigitalBigInteger bi : sbi) {
      Assertions.assertThat(bi.toString().length()).isEqualTo(3);
    }
  }

  @Test
  public void testSizeCalculation() {
    RangeGenerator dense = RangeGenerator.forNDigits(3);
    Set<DigitalBigInteger> sbi = exhaustGeneratorAssertSize(dense, dense.size());
  }
}
