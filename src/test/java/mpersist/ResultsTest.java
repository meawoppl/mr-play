package mpersist;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class ResultsTest {
  @Test
  public void testResultsPrinterEmpty() {
    Map<BigInteger, Integer> r = new HashMap<>();
    Results.printResults(r);
  }

  @Test
  public void testResultsPrinter() {
    Map<BigInteger, Integer> r = new HashMap<>();
    r.put(new BigInteger("1"), 30);
    r.put(new BigInteger("2"), 30);
    r.put(new BigInteger("3"), 30);
    Results.printResults(r);
  }
}
