import com.google.common.collect.Iterators;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Iterator;

public class ConcatGenerator extends PlausibleGenerator {
  private int size;
  Iterator<BigInteger> base = Collections.emptyIterator();

  public ConcatGenerator(PlausibleGenerator... generators) {
    for (PlausibleGenerator g : generators) {
      base = Iterators.concat(base, g);
      size += g.size();
    }
  }

  @Override
  public boolean hasNext() {
    return base.hasNext();
  }

  @Override
  public BigInteger next() {
    return base.next();
  }

  @Override
  int size() {
    return size;
  }
}
