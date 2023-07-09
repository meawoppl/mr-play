package mpersist;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.Random;
import java.util.stream.IntStream;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class PureFuncsTest {
  @Test
  public void testDigitSorter() {
    Assertions.assertThat(PureFuncs.sortedDigitString("123")).isEqualTo("123");
    Assertions.assertThat(PureFuncs.sortedDigitString("321")).isEqualTo("123");
    Assertions.assertThat(PureFuncs.sortedDigitString("0321")).isEqualTo("0123");
  }

  @Test
  public void testToIntArray() {
    {
      BigInteger bi = new BigInteger("123");
      assertArrayEquals(PureFuncs.toIntArray(bi), new int[] {1, 2, 3});
    }
    {
      BigInteger bi = new BigInteger("123000");
      assertArrayEquals(PureFuncs.toIntArray(bi), new int[] {1, 2, 3, 0, 0, 0});
    }
  }

  @Test
  public void testNCharsOf() {
    Assertions.assertThat(PureFuncs.nCharactersOf(5, "1")).isEqualTo("11111");

    Assertions.assertThat(PureFuncs.nCharactersOf(5, "a")).isEqualTo("aaaaa");
  }

  @Test
  public void testDigitHistogram() {
    int[] hist = PureFuncs.digitHistogram(new BigInteger("123"));
    Assertions.assertThat(hist.length).isEqualTo(10);
    Assertions.assertThat(hist).isEqualTo(new int[] {0, 1, 1, 1, 0, 0, 0, 0, 0, 0});
  }

  @Test
  public void testDigitHistogramLonger() {
    IntStream ints = new Random(2).ints(0, 10000000).limit(100);
    ints.forEach(
        (i) -> {
          int[] hist = PureFuncs.digitHistogram(BigInteger.valueOf(i));
          Assertions.assertThat(hist.length).isEqualTo(10);
          for (int v : hist) {
            Assertions.assertThat(v).isGreaterThanOrEqualTo(0);
          }
        });
  }
}
