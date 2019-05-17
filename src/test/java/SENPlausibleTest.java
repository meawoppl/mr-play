import java.math.BigInteger;
import junit.framework.TestCase;
import org.junit.Test;

public class SENPlausibleTest extends TestCase {
  @Test
  public void testPlausibleInit() {
    new SENPlausible(1, 2, 3);
  }

  @Test
  public void testPlausibleAsBig() {
    SENPlausible p = new SENPlausible(1, 2, 3);
    assertEquals(new BigInteger("788999"), p.asBigInteger());
  }

  @Test
  public void testPrefix() {
    SENPlausible p = new SENPlausible("6", 1, 1, 1);
    assertEquals(new BigInteger("6789"), p.asBigInteger());
  }

  @Test
  public void testNDigits() {
    SENPlausible p = new SENPlausible("6", 1, 1, 1);
    assertEquals(4, p.nDigits());
  }
}
