package mpersist.generators;

import java.util.ArrayList;
import java.util.List;

public class ConcatGeneratorBuilder {
  private List<PlausibleGenerator> generators = new ArrayList<>();

  public void append(PlausibleGenerator generator) {
    generators.add(generator);
  }

  public ConcatGenerator build() {
    return new ConcatGenerator(generators);
  }
}
