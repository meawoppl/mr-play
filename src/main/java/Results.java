import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Results {
  private Results() {}

  public static void printResults(Map<BigInteger, Integer> results) {
    Map<Integer, List<BigInteger>> mapping = groupedOnValue(results);

    Integer highest = mapping.keySet().stream().max(Integer::compareTo).orElse(0);

    for (int i = 3; i <= highest; i++) {
      if (!mapping.containsKey(i)) continue;
      System.out.println("========");
      System.out.println(String.format("%d (%d)", i, mapping.get(i).size()));
      System.out.println("========");
      mapping.get(i).stream().sorted().forEach((bi) -> System.out.println(bi.toString()));

      System.out.println();
    }
  }

  /**
   * Super not obvious. For a Map<K, V> reformulate a map collecting all entries of K into a
   * collection which key to V.
   *
   * <pre>{"a": 1, "b": 1, "c": 2} -> {1: ["a", "b"], 2: ["c"]}</pre>
   */
  private static <K, V> Map<V, List<K>> groupedOnValue(Map<K, V> m) {
    Map<V, List<K>> ret = new HashMap<>();
    m.values()
        .stream()
        .distinct()
        .forEach(
            g ->
                ret.put(
                    g,
                    m.keySet().stream().filter(k -> m.get(k) == g).collect(Collectors.toList())));

    return ret;
  }
}
