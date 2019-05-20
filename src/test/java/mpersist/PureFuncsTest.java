package mpersist;

import static org.junit.Assert.*;

import java.math.BigInteger;
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
    Assertions.assertThat(PureFuncs.nCharactersOf(5, "")).isEqualTo("");

    Assertions.assertThat(PureFuncs.nCharactersOf(5, "a")).isEqualTo("aaaaa");
  }
}
