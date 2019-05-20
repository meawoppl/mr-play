package mpersist.generators;

import java.math.BigInteger;

public class FiveGenerator extends PlausibleGenerator {

  //
  //            for (int i = 1; i <= nDigits; i++) {
  //        dirtyAppendIterator(new
  // mpersist.generators.SENGenerator(mpersist.PureFuncs.nCharactersOf(i, "5"), nDigits - i));
  //    }

  @Override
  public boolean hasNext() {
    return false;
  }

  @Override
  public BigInteger next() {
    return null;
  }

  @Override
  public int size() {
    return 0;
  }
}
