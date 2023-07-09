package mpersist.generators;

import java.math.BigInteger;
import java.util.Random;
import mpersist.forms.DigitalBigInteger;

public class BigPrimeGenerator extends PlausibleGenerator {
  private final int nBits;
  private final Random random;

  public BigPrimeGenerator(int nBits) {
    this.nBits = nBits;
    this.random = new Random();
  }

  public BigPrimeGenerator(int nBits, Random random) {
    this.nBits = nBits;
    this.random = random;
  }

  @Override
  public DigitalBigInteger next() {
    return new DigitalBigInteger(BigInteger.probablePrime(nBits, random));
  }

  @Override
  public boolean hasNext() {
    return true;
  }

  @Override
  public long size() {
    return Long.MAX_VALUE;
  }
}
