import java.math.BigInteger;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import junit.framework.TestCase;
import org.junit.Test;

public class PlausibleGeneratorTest extends TestCase {
  private class TestClass extends PlausibleGenerator {
    private final int n;
    private AtomicInteger m = new AtomicInteger(0);

    public TestClass(int n) {
      this.n = n;
    }

    @Override
    int size() {
      return n;
    }

    @Override
    public boolean hasNext() {
      return m.intValue() < n;
    }

    @Override
    public BigInteger next() {
      return BigInteger.valueOf(m.getAndIncrement());
    }
  }

  @Test
  public void testTestClassImpl() {
    TestClass t = new TestClass(3);
    assertEquals(t.size(), 3);
    assertEquals(t.toSet().size(), 3);
  }

  @Test
  public void testToParallelStream() {
    Stream<BigInteger> bigIntegerStream = new TestClass(3).toParallelStream();
    assertTrue(bigIntegerStream.isParallel());
  }

  @Test
  public void testToSet() {
    TestClass t = new TestClass(3);
    assertEquals(t.size(), 3);
    Set<BigInteger> set = t.toSet();
    assertTrue(set.contains(BigInteger.valueOf(0)));
    assertTrue(set.contains(BigInteger.valueOf(1)));
    assertTrue(set.contains(BigInteger.valueOf(2)));
  }
}
