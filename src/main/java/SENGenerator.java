import java.math.BigInteger;

/**
 * This is a class that generate the ordered combinations of 789 compositions of size equal to
 * nDigits.
 *
 * <p>Basically, the number of nines is equal to nDigits - (#7's + #8's) The number of 7's and 8's
 * is searched as an upper diagonal matrix including the trace
 */
public class SENGenerator extends PlausibleGenerator {
  private final int nDigits;
  private final String prefix;

  private int s = 0;
  private int e = 0;

  public SENGenerator(String prefix, int nDigits) {
    assert (nDigits > 0 || !prefix.equals(""));
    this.nDigits = nDigits;
    this.prefix = prefix;
  }

  public SENGenerator(int nDigits) {
    this("", nDigits);
  }

  @Override
  public BigInteger next() {
    int n = nDigits - (s + e);
    SENPlausible p = new SENPlausible(prefix, s, e, n);

    e += 1;
    if ((s + e) > nDigits) {
      s += 1;
      e = 0;
    }

    return p.asBigInteger();
  }

  @Override
  public boolean hasNext() {
    return (s <= nDigits);
  }

  @Override
  public int size() {
    return ((nDigits + 1) * (nDigits + 2)) / 2;
  }
}
