import java.util.Iterator;

/**
 * This is a class that generate the ordered combinations of 789 compositions of size equal to
 * nDigits.
 *
 * <p>Basically, the number of nines is equal to nDigits - (#7's + #8's) The number of 7's and 8's
 * is searched as an upper diagonal matrix including the trace
 */
public class SENGenerator implements Iterator<Plausible> {
  private final int nDigits;
  private int s = 0;
  private int e = 0;

  public SENGenerator(int nDigits) {
    this.nDigits = nDigits;
  }

  @Override
  public Plausible next() {
    int n = nDigits - (s + e);
    Plausible p = new Plausible(s, e, n);

    e += 1;
    if ((s + e) > nDigits) {
      s += 1;
      e = 0;
    }

    return p;
  }

  @Override
  public boolean hasNext() {
    return (s <= nDigits);
  }
}
