package mpersist.generators;

import com.google.common.collect.Iterators;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

public class GeneratorTestHelpers {
  public <T> Set<T> exhaustGeneratorAssertSize(@NotNull Iterator<T> gen, long size) {
    HashSet<T> set = new HashSet<>();
    gen.forEachRemaining(set::add);
    Assertions.assertThat(set).size().isEqualTo(size);
    return set;
  }

  @Test
  public void testExhaustGeneratorAssertSize() {
    Set<Integer> r = exhaustGeneratorAssertSize(Iterators.forArray(1, 2, 3), 3);
    Assertions.assertThat(r).containsExactlyInAnyOrder(1, 2, 3);
  }
}
