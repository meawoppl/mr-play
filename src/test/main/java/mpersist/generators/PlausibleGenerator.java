package mpersist.generators;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import mpersist.forms.DigitalBigInteger;

public abstract class PlausibleGenerator implements Iterator<DigitalBigInteger> {
  public abstract long size();

  public Stream<BigInteger> toParallelStream() {
    int properties =
        Spliterator.NONNULL
            | Spliterator.SIZED
            | Spliterator.SORTED
            | Spliterator.DISTINCT
            | Spliterator.IMMUTABLE;
    Stream<BigInteger> p =
        StreamSupport.stream(Spliterators.spliteratorUnknownSize(this, properties), false);
    return p.parallel().unordered();
  }

  public Set<BigInteger> toSet() {
    HashSet<BigInteger> set = new HashSet<>();
    this.forEachRemaining(set::add);
    return set;
  }
}
