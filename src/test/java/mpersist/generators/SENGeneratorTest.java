package mpersist.generators;

import java.math.BigInteger;
import java.util.*;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class SENGeneratorTest extends GeneratorTestHelpers {
  @Test
  public void testGenerationSingleDigit() {
    SENGenerator pg = new SENGenerator(1);
    exhaustGeneratorAssertSize(pg, 3);
  }

  @Test
  public void testGenerationDoubleDigit() {
    SENGenerator pg = new SENGenerator(2);
    exhaustGeneratorAssertSize(pg, 6);
  }

  @Test
  public void testGenerationNSizeMath() {
    for (int i = 3; i < 50; i++) {
      SENGenerator pg = new SENGenerator(i);
      // Make sure the size math is right
      int expectedSize = ((i + 1) * (i + 2)) / 2;
      Assertions.assertThat(pg.size()).isEqualTo(expectedSize);

      // Make sure the generator produces that many things.
      exhaustGeneratorAssertSize(pg, expectedSize);
    }
  }

  @Test
  public void testPrefixNullGen() {
    SENGenerator pg = new SENGenerator("1", 0);
    Set<BigInteger> things = exhaustGeneratorAssertSize(pg, 1);
    Assertions.assertThat(things).containsExactly(new BigInteger("1"));
  }
}
