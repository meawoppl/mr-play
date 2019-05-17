import java.util.Objects;

public class SENPlausible {
  final String prefix;
  final int sevens;
  final int eights;
  final int nines;

  public SENPlausible(String prefix, int sevens, int eights, int nines) {
    assert ((sevens + eights + nines) > 0 || !prefix.equals(""));
    this.sevens = sevens;
    this.eights = eights;
    this.nines = nines;
    this.prefix = prefix;
  }

  public SENPlausible(int sevens, int eights, int nines) {
    this("", sevens, eights, nines);
  }

  public java.math.BigInteger asBigInteger() {
    String s =
        prefix
            + PureFuncs.nCharactersOf(sevens, "7")
            + PureFuncs.nCharactersOf(eights, "8")
            + PureFuncs.nCharactersOf(nines, "9");

    return new java.math.BigInteger(s);
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
    if (!(o instanceof SENPlausible)) return false;

    SENPlausible p = (SENPlausible) o;
    return p.sevens == this.sevens && p.eights == this.eights && p.nines == this.nines;
  }

  @Override
  public String toString() {
    return String.format("7(%d) 8(%d) 9(%d)", sevens, eights, nines);
  }
}
