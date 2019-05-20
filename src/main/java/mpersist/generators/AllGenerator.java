package mpersist.generators;

import java.math.BigInteger;

public class AllGenerator extends PlausibleGenerator {
  PlausibleGenerator base;

  public AllGenerator(int nDigits) {
    // Summarizing, a term a(n) for n > 2 consists of 7's, 8's and 9's with a prefix of one of the
    // following
    // sets of digits: {{}, {2}, {3}, {4}, {6}, {2,6}, {3,5}, {5, 5,...}}

    base =
        new ConcatGenerator(
            new SENGenerator("", nDigits),
            new SENGenerator("2", nDigits - 1),
            new SENGenerator("3", nDigits - 1),
            new SENGenerator("4", nDigits - 1),
            new SENGenerator("6", nDigits - 1),
            new SENGenerator("26", nDigits - 2),
            new SENGenerator("35", nDigits - 2));
  }

  @Override
  public int size() {
    return base.size();
  }

  @Override
  public boolean hasNext() {
    return base.hasNext();
  }

  @Override
  public BigInteger next() {
    return base.next();
  }

  // https://oeis.org/A003001
}
