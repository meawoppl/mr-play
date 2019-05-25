package mpersist;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class PersistenceResultsTest {
  @Test
  public void testResultsPrinterEmpty() {
    PersistenceResults pr = new PersistenceResults();
    pr.printResults();
  }

  @Test
  public void testResultsPrinter() {
    PersistenceResults pr = new PersistenceResults();
    pr.addResult(new BigInteger("1"), 30);
    pr.addResult(new BigInteger("2"), 30);
    pr.addResult(new BigInteger("3"), 30);
    pr.printResults();
  }
}
