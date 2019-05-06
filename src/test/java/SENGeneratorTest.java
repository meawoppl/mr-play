import java.util.*;
import java.util.stream.StreamSupport;
import junit.framework.TestCase;
import org.junit.Test;

public class SENGeneratorTest extends TestCase {
  private <T> Set<T> exhaustGenerator(Iterator<T> gen) {
    HashSet<T> set = new HashSet<>();
    gen.forEachRemaining(set::add);
    return set;
  }

  @Test
  public void testGenerationSingleDigit() {
    SENGenerator pg = new SENGenerator(1);
    Set<Plausible> things = exhaustGenerator(pg);
    assertEquals(3, things.size());
  }

  @Test
  public void testGenerationDoubleDigit() {
    SENGenerator pg = new SENGenerator(2);
    Set<Plausible> things = exhaustGenerator(pg);
    assertEquals(6, things.size());
  }

  @Test
  public void testGenerationNSize() {
    for (int i = 3; i < 50; i++) {
      SENGenerator pg = new SENGenerator(i);
      Set<Plausible> things = exhaustGenerator(pg);
      int udSize = ((i + 1) * (i + 2)) / 2;
      assertEquals(udSize, things.size());
    }
  }

  @Test
  public void testDoTheSearch() {
    SENGenerator pg = new SENGenerator(1000);
    StreamSupport.stream(Spliterators.spliteratorUnknownSize(pg, Spliterator.ORDERED), false)
        .parallel()
        .filter((p) -> PureFuncs.computeMultiplicativeResistance(p.asBigInteger()) > 3)
        .forEachOrdered(
            (p) -> {
              System.out.println(
                  String.format(
                      "%s - %d",
                      p.asBigInteger().toString(),
                      PureFuncs.computeMultiplicativeResistance(p.asBigInteger())));
            });
    assert (false);
  }
}
