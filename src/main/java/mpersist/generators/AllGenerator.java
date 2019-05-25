package mpersist.generators;

import mpersist.forms.DigitalBigInteger;

public class AllGenerator extends PlausibleGenerator {
  PlausibleGenerator base;

  public AllGenerator(int nDigits) {
    // Summarizing, a term a(n) for n > 2 consists of 7's, 8's and 9's with a prefix of one of the
    // following
    // sets of digits: {{}, {2}, {3}, {4}, {6}, {2,6}, {3,5}, {5, 5,...}}

    base =
        new ConcatGenerator(
            new SENGenerator("", nDigits),
            new SENGenerator("2", nDigits),
            new SENGenerator("26", nDigits),
            new SENGenerator("3", nDigits),
            new FSENGenerator("35", nDigits),
            new SENGenerator("36", nDigits),
            new SENGenerator("4", nDigits),
            new SENGenerator("6", nDigits),
            new SENGenerator("46", nDigits),
            new FSENGenerator("", nDigits),
            new SENGenerator("6", nDigits));
  }

  @Override
  public long size() {
    return base.size();
  }

  @Override
  public boolean hasNext() {
    return base.hasNext();
  }

  @Override
  public DigitalBigInteger next() {
    return base.next();
  }

  // https://oeis.org/A003001
}
