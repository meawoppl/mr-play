package mpersist.generators;

import java.util.concurrent.atomic.AtomicLong;
import mpersist.forms.DigitalBigInteger;

public class RangeGenerator extends PlausibleGenerator {
  private final AtomicLong ai;
  private final long start;
  private final long stop;

  RangeGenerator(long start, long stop) {
    assert (stop > start);
    this.start = start;
    this.stop = stop;
    this.ai = new AtomicLong(start);
  }

  @Override
  public long size() {
    return stop - start;
  }

  @Override
  public DigitalBigInteger next() {
    return new DigitalBigInteger(this.ai.getAndIncrement());
  }

  @Override
  public boolean hasNext() {
    return ai.get() < stop;
  }

  public static RangeGenerator forNDigits(int nDigits) {
    return new RangeGenerator(
        Math.round(Math.pow(10, nDigits - 1)), Math.round(Math.pow(10, nDigits)));
  }
}
