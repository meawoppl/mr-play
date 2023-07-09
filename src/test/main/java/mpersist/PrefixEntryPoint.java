package mpersist;

import java.util.HashMap;
import java.util.Map;
import mpersist.forms.DigitalBigInteger;
import mpersist.generators.RangeGenerator;
import mpersist.rules.Rules;
import mpersist.rules.base.TerminationCase;

public class PrefixEntryPoint {
  public static void main(String[] args) {
    Map<String, Integer> prefixes = new HashMap<>();

    int digitLength = 5;

    RangeGenerator.forNDigits(digitLength)
        .forEachRemaining(
            (dbi) -> {
              DigitalBigInteger result;
              try {
                result = Rules.applyRepeated(dbi);
              } catch (TerminationCase t) {
                return;
              }

              String p = result.trimSEN().toString();
              prefixes.put(p, prefixes.getOrDefault(p, 0) + 1);
            });

    prefixes
        .keySet()
        .stream()
        .sorted()
        .forEachOrdered(
            (prefix) -> {
              String pad = PureFuncs.nCharactersOf(digitLength - prefix.length(), "*");
              System.out.println(String.format("'%s%s' - %d", prefix, pad, prefixes.get(prefix)));
            });
  }
}
