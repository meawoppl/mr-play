package mpersist;

import java.math.BigInteger;
import java.util.*;
import me.tongfei.progressbar.ProgressBar;
import mpersist.generators.AllGenerator;

public class MiningEntryPoint {
  public static void main(String[] args) {

    for (int i = 1000; i < 1001; i++) {
      long start = System.currentTimeMillis();
      Map<BigInteger, Integer> results = new HashMap<>();
      String task = String.format("%d digits.", i);
      AllGenerator allGenerator = new AllGenerator(i);
      try (ProgressBar pb = new ProgressBar(task, allGenerator.size(), 50)) {
        allGenerator
            .toParallelStream()
            .peek((v) -> pb.step())
            .filter((p) -> Persistence.compute(p) > 3)
            .forEach(
                (p) -> {
                  results.put(p, Persistence.compute(p));
                  pb.setExtraMessage(String.format("%d found...", results.size()));
                });
      }
      long end = System.currentTimeMillis();

      System.out.println(String.format("mpersist.Results for %d digits", i));
      System.out.println(
          String.format("%.01fk/second", (allGenerator.size() * 1.0) / (end - start)));
      Results.printResults(results);
    }
  }
}
