import java.math.BigInteger;
import java.util.*;
import me.tongfei.progressbar.ProgressBar;

public class EntryPoint {
  public static void main(String[] args) {

    for (int i = 1000; i < 1001; i++) {
      Map<BigInteger, Integer> results = new HashMap<>();
      String task = String.format("Searching %d digits.", i);
      AllGenerator pg = new AllGenerator(i);
      try (ProgressBar pb = new ProgressBar(task, pg.size(), 50)) {
        pg.toParallelStream()
            .peek((v) -> pb.step())
            .filter((p) -> PureFuncs.computeMultiplicativeResistance(p) > 3)
            .forEach(
                (p) -> {
                  results.put(p, PureFuncs.computeMultiplicativeResistance(p));
                  pb.setExtraMessage(String.format("%d found...", results.size()));
                });
      }

      System.out.println(String.format("Results for %d digits", i));
      Results.printResults(results);
    }
  }
}
