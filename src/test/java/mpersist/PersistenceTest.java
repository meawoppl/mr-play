package mpersist;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;

import java.math.BigInteger;
import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class PersistenceTest {

  @Test
  public void testZero() {
    for (int i = 0; i < 10; i++) {
      Assertions.assertThat(Persistence.compute(i)).isEqualTo(0);
    }
  }

  @Test
  public void testOne() {

    Assertions.assertThat(Persistence.compute(10)).isEqualTo(1);
  }

  @Test
  public void testTwo() {
    Assertions.assertThat(Persistence.compute(25)).isEqualTo(2);
  }

  @Test
  public void testLong() {
    Assertions.assertThat(Persistence.compute(277777788888899L)).isEqualTo(11);
  }

  @Test
  public void testMultTrick() {
    // Two #9's become 4 #3's
    Assertions.assertThat(Persistence.compute(277777788888899L))
        .isEqualTo(Persistence.compute(23333777777888888L));
  }

  @Test
  public void testStrIntEle() {
    assertArrayEquals(PureFuncs.stringToIntElements("123678"), new int[] {1, 2, 3, 6, 7, 8});
  }

  @Test
  public void testAllTheMinimals() {
    long[] minimals =
        new long[] {
          0, 10, 25, 39, 77, 679, 6788, 68889, 2677889, 26888999, 3778888999L, 277777788888899L
        };

    for (int i = 0; i < minimals.length; i++) {
      long value = minimals[i];
      Assertions.assertThat(Persistence.compute(value)).isEqualTo(i);
    }
  }

  @Test
  public void testManyNines() {
    for (int i = 1; i < 1000; i++) {
      String trial = String.join("", Collections.nCopies(i, "9"));
      Persistence.compute(trial);
    }
  }

  @Test
  public void testClaim() {
    // This is a false claim I found in a resource somewhere:
    assertNotEquals(12, Persistence.compute(new BigInteger("55555555555555557777777777777")));
  }
}
