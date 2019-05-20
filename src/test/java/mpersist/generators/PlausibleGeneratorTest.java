package mpersist.generators;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import mpersist.forms.DigitalBigInteger;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class PlausibleGeneratorTest {
  private class TestClass extends PlausibleGenerator {
    private final int n;
    private AtomicInteger m = new AtomicInteger(0);

    public TestClass(int n) {
      this.n = n;
    }

    @Override
    public long size() {
      return n;
    }

    @Override
    public boolean hasNext() {
      return m.intValue() < n;
    }

    @Override
    public DigitalBigInteger next() {
      return new DigitalBigInteger(m.getAndIncrement());
    }
  }

  @Test
  public void testTestClassImpl() {
    TestClass t = new TestClass(3);
    Assertions.assertThat(t.size()).isEqualTo(3);
    Assertions.assertThat(t.toSet())
        .containsExactlyInAnyOrder(new BigInteger("0"), new BigInteger("1"), new BigInteger("2"));
  }

  @Test
  public void testToParallelStream() {
    Stream<BigInteger> bigIntegerStream = new TestClass(3).toParallelStream();
    Assertions.assertThat(bigIntegerStream.isParallel()).isTrue();
  }

  @Test
  public void testToSet() {
    TestClass t = new TestClass(3);
    Assertions.assertThat(t.size()).isEqualTo(3);
    Assertions.assertThat(t.toSet())
        .containsExactlyInAnyOrder(new BigInteger("0"), new BigInteger("1"), new BigInteger("2"));
  }
}
