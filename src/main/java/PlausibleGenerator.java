import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public abstract class PlausibleGenerator implements Iterator<BigInteger> {
  abstract int size();

  Stream<BigInteger> toParallelStream() {
    int properties =
        Spliterator.NONNULL | Spliterator.SIZED | Spliterator.SORTED | Spliterator.DISTINCT;
    Stream<BigInteger> p =
        StreamSupport.stream(Spliterators.spliterator(this, this.size(), properties), false);
    return p.parallel().unordered();
  }

  Set<BigInteger> toSet() {
    HashSet<BigInteger> set = new HashSet<>();
    this.forEachRemaining(set::add);
    return set;
  }
}
