package mpersist.generators;

import com.google.common.collect.Iterators;
import java.util.Iterator;
import java.util.List;
import mpersist.forms.DigitalBigInteger;

public class ConcatGenerator extends PlausibleGenerator {
  private int size;
  private final Iterator<DigitalBigInteger> base;

  public ConcatGenerator(List<PlausibleGenerator> generators) {
    this(generators.toArray(new PlausibleGenerator[0]));
  }

  public ConcatGenerator(PlausibleGenerator... generators) {
    base = Iterators.concat(Iterators.forArray(generators));

    for (PlausibleGenerator g : generators) {
      size += g.size();
    }
  }

  @Override
  public boolean hasNext() {
    return base.hasNext();
  }

  @Override
  public DigitalBigInteger next() {
    return base.next();
  }

  @Override
  public long size() {
    return size;
  }
}
