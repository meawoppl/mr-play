package mpersist.generators;

import java.math.BigInteger;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class AllGeneratorTest extends GeneratorTestHelpers {
  @Test
  public void testGeneratedSizes() {
    for (int i = 2; i < 10; i++) {
      AllGenerator ag = new AllGenerator(i);
      Set<BigInteger> results = ag.toSet();
      final int nDigits = i;
      results.forEach((bi) -> Assertions.assertThat(bi.toString().length()).isEqualTo(nDigits));
    }
  }
}
