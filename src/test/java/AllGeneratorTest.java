import java.math.BigInteger;
import java.util.Set;
import org.junit.Test;

public class AllGeneratorTest extends GeneratorTestHelpers {
  @Test
  public void testGeneratedSizes() {
    for (int i = 2; i < 10; i++) {
      AllGenerator ag = new AllGenerator(i);
      Set<BigInteger> results = exhaustGeneratorAssertSize(ag, 20);
      final int nDigits = i;
      results.forEach(
          (bi) -> {
            assertEquals(nDigits, bi.toString().length());
          });
    }
  }
}
