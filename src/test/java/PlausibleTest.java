import static org.junit.Assert.*;

import java.math.BigInteger;
import org.junit.Test;

public class PlausibleTest {
  @Test
  public void testPlausibleInit() {
    new Plausible(1, 2, 3);
  }

  @Test
  public void testPlausibleAsBig() {
    Plausible p = new Plausible(1, 2, 3);
    assertEquals(new BigInteger("788999"), p.asBigInteger());
  }
}
