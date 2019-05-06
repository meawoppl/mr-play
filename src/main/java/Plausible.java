import java.math.BigInteger;
import java.util.Objects;

public class Plausible {
  public static final BigInteger SEVEN = new BigInteger("7");
  public static final BigInteger EIGHT = new BigInteger("8");
  public static final BigInteger NINE = new BigInteger("9");

  int sevens;
  int eights;
  int nines;

  public Plausible(int sevens, int eights, int nines) {
    this.sevens = sevens;
    this.eights = eights;
    this.nines = nines;
  }

  //  public BigInteger asSortedBigInteger() {
  //
  //  }

  public BigInteger asBigInteger() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < sevens; i++) {
      sb.append("7");
    }

    for (int i = 0; i < eights; i++) {
      sb.append("8");
    }

    for (int i = 0; i < nines; i++) {
      sb.append("9");
    }

    return new BigInteger(sb.toString());
  }

  public int nDigits() {
    return asBigInteger().toString().length();
  }

  @Override
  public int hashCode() {
    return Objects.hash(sevens, eights, nines);
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Plausible)) return false;

    Plausible p = (Plausible) o;
    return p.sevens == this.sevens && p.eights == this.eights && p.nines == this.nines;
  }

  @Override
  public String toString() {
    return String.format("7(%d) 8(%d) 9(%d)", sevens, eights, nines);
  }
}
