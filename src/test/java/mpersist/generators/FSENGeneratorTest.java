package mpersist.generators;


import mpersist.forms.DigitalBigInteger;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Set;

public class FSENGeneratorTest extends GeneratorTestHelpers {
  @Test
  public void testGenerator(){
    PlausibleGenerator gen = new FSENGenerator("4", 2);
    Set<DigitalBigInteger> dbi = exhaustGeneratorAssertSize(gen, 3);

    dbi.forEach((bi)-> Assertions.assertThat(bi.nDigits()).isEqualTo(2));
  }
}