package mpersist;

import java.util.*;
import me.tongfei.progressbar.ProgressBar;
import mpersist.generators.AllGenerator;
import mpersist.rules.Rules;

public class MiningEntryPoint {
  public static void main(String[] args) {

    PersistenceResults results = new PersistenceResults();

    int totalSearched = 0;

    long start = System.currentTimeMillis();
    for (int i = 200; i < 201; i++) {
      String task = String.format("%d digits.", i);
      AllGenerator allGenerator = new AllGenerator(i);
      try (ProgressBar pb = new ProgressBar(task, allGenerator.size(), 500)) {
        allGenerator
            .toParallelStream()
            .peek((v) -> pb.step())
            .filter((p) -> Persistence.compute(p) >= 3)
            .forEach(
                (p) -> {
                  results.addResult(Rules.toMinimalForm(p), Persistence.compute(p));
                  pb.setExtraMessage(String.format("%d found...", results.size()));
                });
      }
      long end = System.currentTimeMillis();

      System.out.println(String.format("mpersist.PersistenceResults for %d digits", i));
      System.out.println(
          String.format("%.01fk/second", (allGenerator.size() * 1.0) / (end - start)));
      totalSearched += allGenerator.size();
    }

    results.printSizes();
    System.out.println(
        String.format(
            "%.01fk/second", (totalSearched * 1.0) / (System.currentTimeMillis() - start)));
  }
}
