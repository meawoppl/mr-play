import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import junit.framework.TestCase;
import org.jetbrains.annotations.NotNull;

public class GeneratorTestHelpers extends TestCase {
  public <T> Set<T> exhaustGeneratorAssertSize(@NotNull Iterator<T> gen, int size) {
    HashSet<T> set = new HashSet<>();
    gen.forEachRemaining(set::add);
    assertEquals(size, set.size());
    return set;
  }
}
