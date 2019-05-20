package mpersist.generators;

import mpersist.PureFuncs;
import mpersist.forms.DigitalBigInteger;

public class FSENGenerator extends PlausibleGenerator {
  private final String prefix;
  private final PlausibleGenerator generator;

  public FSENGenerator(String prefix, int nDigits) {
    this.prefix = prefix;

    ConcatGeneratorBuilder builder = new ConcatGeneratorBuilder();

    int maximumFives = nDigits - prefix.length();
    for (int fives = 0; fives < maximumFives; fives++) {
      String pre = PureFuncs.nCharactersOf(fives, "5");
      builder.append(new SENGenerator(pre, maximumFives));
    }

    this.generator = builder.build();
  }


  @Override
  public long size() {
    return generator.size();
  }

  @Override
  public boolean hasNext() {
    return generator.hasNext();
  }

  @Override
  public DigitalBigInteger next() {
    return new DigitalBigInteger(prefix + generator.next().toString());
  }
}
