import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.Collections;
import org.junit.Assert;
import org.junit.Test;

public class PureFuncsTest {
  @Test
  public void testDigitSorter() {
    assertEquals("123", PureFuncs.sortedDigitString("123"));
    assertEquals("123", PureFuncs.sortedDigitString("321"));
    assertEquals("0123", PureFuncs.sortedDigitString("0321"));
  }

  @Test
  public void testZero() {
    Assert.assertEquals(0, PureFuncs.computeMultiplicativeResistance(0));
  }

  @Test
  public void testOne() {
    Assert.assertEquals(1, PureFuncs.computeMultiplicativeResistance(10));
  }

  @Test
  public void testTwo() {
    Assert.assertEquals(2, PureFuncs.computeMultiplicativeResistance(25));
  }

  @Test
  public void testLong() {
    Assert.assertEquals(11, PureFuncs.computeMultiplicativeResistance(277777788888899L));
  }

  @Test
  public void testMultTrick() {
    // Two #9's become 4 #3's
    Assert.assertEquals(
        PureFuncs.computeMultiplicativeResistance(277777788888899L),
        PureFuncs.computeMultiplicativeResistance(23333777777888888L));
  }

  @Test
  public void testStrIntEle() {
    Assert.assertArrayEquals(PureFuncs.stringToIntElements("123678"), new int[] {1, 2, 3, 6, 7, 8});
  }

  @Test
  public void testAllTheMinimals() {
    long[] minimals =
        new long[] {
          0, 10, 25, 39, 77, 679, 6788, 68889, 2677889, 26888999, 3778888999L, 277777788888899L
        };

    for (int i = 0; i < minimals.length; i++) {
      long value = minimals[i];
      assertEquals(PureFuncs.computeMultiplicativeResistance(value), i);
    }
  }

  @Test
  public void testManyNines() {
    for (int i = 1; i < 1000; i++) {
      String trial = String.join("", Collections.nCopies(i, "9"));
      PureFuncs.computeMultiplicativeResistance(trial);
    }
  }

  @Test
  public void testClaim() {
    // This is a false claim I found in a resource somewhere:
    assertNotEquals(
        12,
        PureFuncs.computeMultiplicativeResistance(new BigInteger("55555555555555557777777777777")));
  }

  @Test
  public void testNCharsOf() {
    assertEquals("", PureFuncs.nCharactersOf(5, ""));

    assertEquals("aaaaa", PureFuncs.nCharactersOf(5, "a"));
  }
}
